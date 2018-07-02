package com.khoubyari.example.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.AbstractController;

import com.khoubyari.example.domain.BookGround;
import com.khoubyari.example.domain.Hotel;
import com.khoubyari.example.service.BookGroundService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/example/v1/grounds")
@Api(tags = {"grounds"})
public class GroundController extends AbstractRestHandler{

	@Autowired
	BookGroundService bookGroundService;
	
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a hotel resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createHotel(@RequestBody BookGround ground,
                                 HttpServletRequest request, HttpServletResponse response) {
        BookGround createdGround = this.bookGroundService.createGround(ground);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdGround.getId()).toString());
    }
    
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single hotel.", notes = "You have to provide a valid hotel ID.")
    public
    @ResponseBody
    BookGround getGround(@ApiParam(value = "The ID of the hotel.", required = true)
                             @PathVariable("id") Long id,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookGround ground = this.bookGroundService.getGround(id);
        checkResourceFound(ground);
        //todo: http://goo.gl/6iNAkz
        return ground;
    }
}
