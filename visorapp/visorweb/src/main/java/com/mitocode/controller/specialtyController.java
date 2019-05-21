/**
 * 
 */
package com.mitocode.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.service.ISpecialtyService;

/**
 * @author mbreyes
 *
 */
@Named
@ViewScoped
public class specialtyController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISpecialtyService specialtyService;
}
