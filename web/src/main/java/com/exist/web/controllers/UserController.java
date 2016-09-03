package com.exist.web.controllers;

import com.exist.model.dto.CSVRowDto;
import com.exist.model.dto.ContactDto;
import com.exist.model.dto.UserProfileDto;
import com.exist.model.exception.EntityAlreadyExistsException;
import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.model.exception.EntityNotOwnedException;
import com.exist.model.exception.InvalidFileTypeException;
import com.exist.services.RoleService;
import com.exist.services.UserProfileService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.BeanToCsv;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private RoleService roleService;

    @RequestMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String get(@RequestParam(value = "sort", required = false) String sort, @RequestParam(value = "dir", required = false) String dir, Model model) {
        model.addAttribute("userList", userProfileService.getAll(sort, dir));
        return "user/list";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createPage(Model model) {
        model.addAttribute("userProfile", new UserProfileDto());
        model.addAttribute("readonly", false);
        model.addAttribute("hidden", true);
        model.addAttribute("createMode", true);
        return "user/profile";
    }

    @RequestMapping(path = "/role/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteRole(@RequestParam Long roleId) throws EntityDoesNotExistException {
        roleService.delete(roleId);
        return "role/list";
    }

    @RequestMapping(path = "/profile/{userId}")
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public String profile(@PathVariable Long userId, Model model) throws EntityDoesNotExistException {
        UserProfileDto userProfile = userProfileService.get(userId);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readonly", true);
        model.addAttribute("hidden", true);
        return "user/profile";
    }

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String create(@ModelAttribute UserProfileDto userProfile) throws EntityAlreadyExistsException {
        userProfileService.create(userProfile);
        return "redirect:/user";
    }

    @RequestMapping(path = "/update/{userId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public String update(@PathVariable Long userId, Model model)
            throws EntityDoesNotExistException {
        UserProfileDto userProfile = userProfileService.get(userId);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readonly", false);
        model.addAttribute("hidden", false);
        model.addAttribute("createMode", false);
        return "user/profile";
    }

    @RequestMapping(path = "/update/contactRole/{userId}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public String updateContactRole(@PathVariable Long userId, Model model)
            throws EntityDoesNotExistException {
        UserProfileDto userProfile = userProfileService.get(userId);
        model.addAttribute("userProfile", userProfile);
        model.addAttribute("readonly", true);
        model.addAttribute("hidden", false);
        return "user/profile";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfile.id)")
    public String update(@ModelAttribute UserProfileDto userProfile) throws EntityAlreadyExistsException {
        userProfileService.update(userProfile);
        return "redirect:/user/profile/" + userProfile.getId();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@RequestParam Long userId) {
        userProfileService.delete(userId);
        return "redirect:/user";
    }

    @RequestMapping(path = "/profile/contact/delete", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfileId)")
    public String deleteContact(@RequestParam Long userProfileId, @RequestParam Long contactId) {
        userProfileService.removeContact(userProfileId, contactId);
        return "redirect:/user/profile/" + userProfileId;
    }

    @RequestMapping(path = "/profile/contact", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfileId)")
    public String addContact(@RequestParam Long userProfileId, @ModelAttribute ContactDto contactDto) {
        userProfileService.addContact(userProfileId, contactDto);
        return "redirect:/user/profile/" + userProfileId;
    }

    @RequestMapping(path = "/profile/contact", method = RequestMethod.PUT)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userProfileId)")
    public String updateContact(@RequestParam Long userProfileId, @ModelAttribute ContactDto contactDto) {
        userProfileService.updateContact(contactDto);
        return "redirect:/user/profile/" + userProfileId;
    }

    @RequestMapping(value = "/updateFile/{userId}", produces = "text/csv")
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public void downloadUpdateForm(@PathVariable Long userId, HttpServletResponse response) throws EntityDoesNotExistException, IOException {
        response.setContentType("text/csv");
        CSVRowDto csvRowDto = userProfileService.getUpdateFormData(userId);
        response.setHeader("Content-Disposition", "attachment; filename="
                + StringUtils.join(new String[]{csvRowDto.getLastName(), csvRowDto.getFirstName(), csvRowDto.getId() + ""}, '_') + ".csv");
        File file = File.createTempFile("updateFile_" + userId, ".csv");

        CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
        BeanToCsv<CSVRowDto> beanToCsv = new BeanToCsv<>();

        ColumnPositionMappingStrategy<CSVRowDto> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(CSVRowDto.class);

        String[] columnHeader = "id,username,newPassword,title,firstName,middleName,lastName,suffix,birthDate,gwa,dateHired,currentlyEmployed,streetNumber,barangay,city,zipCode".split(",");
        strategy.setColumnMapping(columnHeader);

        beanToCsv.write(strategy, csvWriter, Stream.of(csvRowDto).collect(Collectors.toList()));
        csvWriter.close();

        String line;
        BufferedReader br  = new BufferedReader(new FileReader(file));
        while((line = br.readLine()) != null){
            response.getWriter().write(line + "\n");
        }

        response.getWriter().close();
    }

    @RequestMapping(path = "/uploadFile/{userId}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN') or (hasAuthority('USER') and principal.id == #userId)")
    public String uploadAccounts(@PathVariable Long userId, @RequestParam("file") MultipartFile file) throws InvalidFileTypeException, IOException, EntityNotOwnedException, EntityAlreadyExistsException {
        if(!file.getContentType().equals("text/csv")){
            throw new InvalidFileTypeException("Invalid File Type!", "error.invalid.fileType", new Object[]{"CSV"});
        }

        HeaderColumnNameMappingStrategy<CSVRowDto> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(CSVRowDto.class);

        CsvToBean<CSVRowDto> csvToBean = new CsvToBean<>();
        List<CSVRowDto> csvRowDtos = csvToBean.parse(strategy, new InputStreamReader(file.getInputStream()));


        if(csvRowDtos.stream().count() != 1){
            throw new IllegalArgumentException("Must have exactly one entry of profile");
        }

        if(csvRowDtos.stream().anyMatch(r -> r.getId() != userId)){
            throw new EntityNotOwnedException("Upload form contains a profile id that is not the user",
                    "error.upload.notSelf",
                    null);
        }

        UserProfileDto userProfileDto = userProfileService.uploadForm(csvRowDtos.get(0));

        return "redirect:/user/profile/" + userProfileDto.getId();
    }


}
