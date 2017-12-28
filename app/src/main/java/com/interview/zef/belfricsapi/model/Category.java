package com.interview.zef.belfricsapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zef on 28/12/17.
 */

/*        {
        "category": [
        {
        "id": 4,
        "category_name": "FASHION & ACCESSORIES",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/4/category_image4.png"
        },
        {
        "id": 5,
        "category_name": "GROCERY & VEGETABLES",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/5/category_image5.png"
        },
        {
        "id": 6,
        "category_name": "FOOD & BEVERAGES",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/6/category_image6.png"
        },
        {
        "id": 7,
        "category_name": "PHARMACEUTICAL",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/7/category_image7.png"
        },
        {
        "id": 8,
        "category_name": "GIFTS & SURPRISES",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/8/category_image8.png"
        },
        {
        "id": 9,
        "category_name": "ARTS & CRAFTS",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/9/category_image9.png"
        },
        {
        "id": 10,
        "category_name": "BOOKS & STATIONARY",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/10/category_image10.png"
        },
        {
        "id": 11,
        "category_name": "KIDS & BABY PRODUCTS",
        "image": "http://198.12.152.211/~ummadc/demo/flamb/public/uploads/category/11/category_image11.png"
        }
        ],
        "order_session_id": 0,
        "latitude": "",
        "longitude": "",
        "location": "",
        "orderReview": [],
        "orderReviewCount": 0,
        "result": "success",
        "message": "Categories"
        }
        Online JSON Viewer
        About JSON
        JSON, short for JavaScript Object Notation, is a lightweight computer data interchange format. JSON is a text-based, human-readable format for representing simple data structures and associative arrays (called objects).

        Read more: json.org, wikipedia, google

        In JSON, they take on these forms
        JSON object

        JSON array

        JSON value

        JSON string

        JSON number
        Example
        {
        "firstName": "John",
        "lastName": "Smith",
        "gender": "man",
        "age": 32,
        "address": {
        "streetAddress": "21 2nd Street",
        "city": "New York",
        "state": "NY",
        "postalCode": "10021"
        },
        "phoneNumbers": [
        { "type": "home", "number": "212 555-1234" },
        { "type": "fax", "number": "646 555-4567" }
        ]
        }
        About Online JSON Viewer
        Convert JSON Strings to a Friendly Readable Format
        The application using Ext JS.
        Author: {gabor}

        PayPal - The safer, easier way to pay online!*/
public class Category {

    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("image")
    @Expose
    private String imageUrl;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
