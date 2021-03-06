package dev.codesupport.web.api.controller;

import dev.codesupport.web.common.service.service.RestResponse;
import dev.codesupport.web.domain.User;
import dev.codesupport.web.domain.UserProfile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Defines endpoints and validations for the associated API Contract for the {@link User} resource.
 */
@RestController
@RequestMapping("api/user/v1")
@Api(tags = { "User" })
@Validated
public interface UserProfileController {

    @ApiOperation("Get all User Profiles")
    @GetMapping("/profiles")
    RestResponse<UserProfile> getAllUserProfiles();

    @ApiOperation("Get User Profile by id")
    @GetMapping("/profiles/{id}")
    RestResponse<UserProfile> getUserProfileById(@PathVariable Long id);

}
