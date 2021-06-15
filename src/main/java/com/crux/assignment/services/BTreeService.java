/**
 * 
 */
package com.crux.assignment.services;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crux.assignment.model.BTreeObjModel;
import com.crux.assignment.utility.BTree;
import com.crux.assignment.utility.InitilizeBtree;

/**
 * @author Jenish Lad.
 * @Description: Service class for handling API request
 */

@Service
public class BTreeService {

	@Autowired
	private InitilizeBtree ref;

	/**
	 * @Description: Method for inserting element in B-Tree
	 * @param arr
	 * @return bTreeObjModel
	 */
	public BTreeObjModel insertElement(final int arr[]) {
		BTree btree = ref.initlizeBtreeInstance();
		BTreeObjModel bTreeObjModel = new BTreeObjModel();
		JSONObject bTreeJson = new JSONObject();
		try {
			for (int a : arr) {
				if (!btree.contain(a)) {
					btree.insert(a);
				}
			}
			bTreeJson = btree.show();
			bTreeObjModel.setMsg("Element(s) inserted successfully");
			bTreeObjModel.setJsonBTree(bTreeJson);
		} catch (Exception e) {
			System.out.println("Exception occured in method: insertElement");
			e.printStackTrace();
			throw e;
		}
		return bTreeObjModel;
	}

	/**
	 * @Description: Method for deleting key element from B-Tree
	 * @param element
	 * @return bTreeObjModel
	 */
	public BTreeObjModel deleteElement(final int element) {
		BTree btree = ref.initlizeBtreeInstance();
		BTreeObjModel bTreeObjModel = new BTreeObjModel();
		JSONObject bTreeJson = new JSONObject();
		try {
			if (btree.contain(element)) {
				btree.remove(element);
				bTreeObjModel.setMsg(element + " Element deleted successfully");
			} else {
				bTreeObjModel.setMsg("Element not found in B-Tree");
			}
			bTreeJson = btree.show();
			bTreeObjModel.setJsonBTree(bTreeJson);
		} catch (Exception e) {
			System.out.println("Exception occured in method: deleteElement");
			e.printStackTrace();
			throw e;
		}
		return bTreeObjModel;
	}

	/**
	 * @Description: Method for deleting all element from B-Tree
	 * @param element
	 * @return
	 */
	public BTreeObjModel deleteAll() {
		BTree btree = ref.initlizeBtreeInstance();
		BTreeObjModel bTreeObjModel = new BTreeObjModel();
		JSONObject bTreeJson = new JSONObject();
		try {
			bTreeJson = btree.show();
			System.out.println("B-Tree Size" + bTreeJson.size());
			btree.removeAll(bTreeJson.size(), bTreeJson);
			bTreeObjModel.setMsg("B-Tree is cleared successfully");
			bTreeJson = btree.show();
			bTreeObjModel.setJsonBTree(bTreeJson);
		} catch (Exception e) {
			System.out.println("Exception occured in method: deleteAll");
			e.printStackTrace();
			throw e;
		}
		return bTreeObjModel;
	}

}
