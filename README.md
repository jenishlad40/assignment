# assignment
B-Tree assignment

B-Tree Demo with following operation
1. Insert element
2. Delete element
3. Clear B-Tree


I have exposed following three APIs.
1. An API to accept One of Multiple Integers to construct a B-Tree. Allows further addition to the B-Tree by calling the same API subsequently.
2. An API to delete a value in the B-Tree
3. An API to clear the B-Tree completely

**API Details:**
_Insert API_
Method: POST
URL: http://localhost:8080/api/insert
Payload 1: [6,2,5,4]
Payload 2: [8]

_Response:_
{
    "msg": "Element(s) inserted successfully",
    "jsonBTree": {
        "0": 2,
        "1": 4,
        "2": 5,
        "3": 6,
        "4": 8
    }
}

_Delete Key Element_
Method: DELETE
Positive Case - URL: http://localhost:8080/api/delete/4
_Response:_
{
    "msg": "4 Element deleted successfully",
    "jsonBTree": {
        "0": 2,
        "1": 5,
        "2": 6,
        "3": 8
    }
}
Negative Case - URL: http://localhost:8080/api/delete/40
_Response:_
{
    "msg": "Element not found in B-Tree",
    "jsonBTree": {
        "0": 2,
        "1": 5,
        "2": 6,
        "3": 8
    }
}


_Clear the B-Tree completely_ 
Method: DELETE
URL: http://localhost:8080/api/deleteAll
_Response:_
{
    "msg": "B-Tree is cleared successfully",
    "jsonBTree": {}
}
