/**
 * 
 */
package com.crux.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crux.assignment.model.BTreeObjModel;
import com.crux.assignment.services.BTreeService;

/**
 * @author Jenish Lad.
 *
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

	@Autowired
	private BTreeService bTreeService;

	/**
	 * @Description: Method for handling insert request
	 * @param elements
	 * @return
	 */
	@PostMapping("/insert")
	public BTreeObjModel insretElement(@Validated @RequestBody int elements[]) {
		BTreeObjModel bTreeObjModel = new BTreeObjModel();
		try {
			System.out.println(elements[0]);
			if (elements.length > 0)
				bTreeObjModel = bTreeService.insertElement(elements);
		} catch (Exception e) {
			System.out.println("Exception occured in method: insertElement");
			bTreeObjModel.setMsg("Exception occured" + e);
		}
		return bTreeObjModel;
	}

	/**
	 * @Description: Method for handling delete request for key element
	 * @param element
	 * @return
	 */
	@DeleteMapping("/delete/{element}")
	public BTreeObjModel deleteElement(@Validated @PathVariable int element) {
		BTreeObjModel bTreeObjModel = new BTreeObjModel();
		try {
			bTreeObjModel = bTreeService.deleteElement(element);
		} catch (Exception e) {
			System.out.println("Exception occured in method: deleteElement");
			bTreeObjModel.setMsg("Exception occured" + e);
		}
		return bTreeObjModel;
	}

	/**
	 * @Description: Method for handling delete request
	 * @return
	 */
	@DeleteMapping("/deleteAll")
	public BTreeObjModel DeleteAllElement() {
		BTreeObjModel bTreeObjModel = new BTreeObjModel();
		try {
			bTreeObjModel = bTreeService.deleteAll();
		} catch (Exception e) {
			System.out.println("Exception occured in method: DeleteAllElement");
			bTreeObjModel.setMsg("Exception occured" + e);
		}

		return bTreeObjModel;
	}

}
