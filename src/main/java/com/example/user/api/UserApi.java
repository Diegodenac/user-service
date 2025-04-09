package com.example.user.api;

import com.example.user.model.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

import java.util.List;

public interface UserApi {
    @Tag(name = "Users", description = "Obtain all the users")
    @Operation(
            summary = "List of users",
            description = "All the users"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "${api.response_codes.ok.description}"
                    ),
                    @ApiResponse(
                            responseCode = "500", description = "${api.response_codes.internalServer.description}",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }
                    ),
            }
    )
    ResponseEntity<List<UserDto>> index();
}
