package com.itechsofsolutions.tictactoe.utils.helper

import com.itechsofsolutions.tictactoe.R

class Constants {
    class Invalid {
        companion object {
            const val INVALID_INTEGER: Int = -1
            const val INVALID_LONG: Long = -1
        }
    }

    class Default {
        companion object {
            const val DEFAULT_STRING: String = ""
            const val DEFAULT_INTEGER: Int = 0
            const val DEFAULT_LONG: Long = 0
            const val DEFAULT_BOOLEAN: Boolean = false
            const val DEFAULT_LANGUAGE: String = "pt"
            const val TRUE_INTEGER: Int = 1
            const val TRUE_STRING_1 = "1"
            const val FALSE_INTEGER: Int = 0
            const val SPACE_STRING: String = " "
            const val DATE_FORMAT_TIME = "yyyy-MM-dd'T'hh:mm:ss'Z'"
            const val DATE_FORMAT_TIME_WITHOUT_SEC = "yyyy-MM-dd HH:mm"
            const val APP_DATE_FORMAT = "dd MMMM, yyyy"
            const val ALPHA_1: Float = 1.0f
            const val ALPHA_0: Float = 0.0f
            const val DELAY_SPLASH: Int = 1000
            const val SESSION_OUT = 401
        }
    }

    class Common {
        companion object {
            const val ANDROID_HASH_KEY = "Hash Key"
            const val COMMON_TIME_ZONE = "UTC"
            const val APP_COMMON_DATE_FORMAT: String = "dd MMMM, yyyy"
            const val APP_COMMON_ONLY_DATE_FORMAT: String = "dd MMMM, yyyy"
            const val APP_COMMON_TIME_FORMAT: String = "hh:mm a"
            const val APP_COMMON_DAY_FORMAT: String = "E"
            const val APP_COMMON_MONTH_FORMAT: String = "MMM"
            const val ROLE = "Bearer "
            const val TELEPHONE_URI_STARTING = "tel:"
            const val BASE_URL_APP_RESOURCES = "file:///android_res/"
            const val HTML_JUSTIFIED_STYLE = "<html>" +
                    "<style type='text/css'>" +
                    "@font-face {" +
                    "font-family: MyFont;" +
                    "src: url('font/regular.ttf')" +
                    "}" +
                    "body {" +
                    "margin: 0;" +
                    "padding: 0;" +
                    "font-family: MyFont;" +
                    "font-size: 14px;" +
                    "text-align: justify;" +
                    "color: #313131" +
                    "}" +
                    "</style>" +
                    "<body>%s" +
                    "</body>" +
                    "</html>"
            const val HTML_SMALL_JUSTIFIED_STYLE = "<html>" +
                    "<style type='text/css'>" +
                    "@font-face {" +
                    "font-family: MyFont;" +
                    "src: url('font/regular.ttf')" +
                    "}" +
                    "body {" +
                    "margin: 0;" +
                    "padding: 0;" +
                    "font-family: MyFont;" +
                    "font-size: 12px;" +
                    "text-align: justify;" +
                    "color: #313131" +
                    "}" +
                    "</style>" +
                    "<body>%s" +
                    "</body>" +
                    "</html>"
            const val HTML_MIME_TYPE = "text/html"
            const val HTML_ENCODING = "UTF-8"
        }
    }

    class TableNames {
        companion object {
            const val USER = "USER"
        }
    }

    class ColumnNames {
        companion object {
            const val ID = "ID"
            const val USER_ID = "USER_ID"
            const val USER_NAME = "USER_NAME"
        }
    }

    class File {
        companion object {
            val DIRECTORY_ROOT = DataUtils.getString(R.string.app_name)
            val PREFIX_IMAGE = "IMG_"
            val PREFIX_CROPPED_IMAGE = "IMG_CROPPED_"
            val SUFFIX_IMAGE = ".jpg"
        }
    }

    class JsonKeys {
        //receive field
        companion object {
            const val BLOG = "Blog"
            const val USER = "User"
            const val SUCCESS = "Success"
            const val DATA = "Data"
            const val MESSAGE = "Message"
            const val STATUS_CODE = "StatusCode"

            //registration
            const val EMAIL = "Email"
            const val PHONE = "Phone"
            const val NAME = "Name"
            const val COUNTRY_NAME = "Country"
            const val EMAIL_VERIFICATION_CODE = "EmailVerifyCode"

            //login
            const val IS_EMAIL_ACTIVIVE = "Active"
            const val TOKEN = "Token"
            const val CODE = "Code"

            //homepage
            const val AD = "Ad"
            const val CART_SIZE = "CartLength"
            const val CATEGORIES = "Categories"
            const val FLASH_SALE = "FlashSale"
            const val NEW_ARRIVAL = "NewArrival"
            const val TODAYS_OFFER = "TodaysOffer"
            const val TRENDING_ITEM = "TrendingItems"

            //ad
            const val ID = "ID"
            const val AD_LINKED_URL = "Url"
            const val AD_IMAGE_URL = "Image"

            //category
            const val TITLE = "Name"
            const val TOTAL_PRODUCT_COUNT = "TotalProducts"
            const val IMAGE_URL = "ImageUrl"
            const val HAS_CHILD = "HasChild"

            //flash
            const val FLASH_END_DATE = "EndDate"
            const val FLASH_PRODUCT = "FlashDealProducts"

            //product
            const val PRODUCT = "Product"
            const val PRODUCT_TITLE = "Title"
            const val SHORT_DESCRIPTION = "ShortDescription"
            const val REGULAR_PRICE = "RegularPrice"
            const val SELL_PRICE = "SellPrice2"
            const val IS_IN_CART = "IsInCart"
            const val IS__IN_WISHLIST = "IsInWishlist"
            const val QUANTITY = "Quantity"
            const val BRAND_NAME = "BrandName"

            //todays offer
            const val TODAYS_IMAGE_URL = "Image"
            const val OFFER_DESCRIPTION = "TextContent"
            const val HEARDER_TITLE = "HeaderTitle"

            //wishlist
            const val WISHLIST = "Wishlist"

            //sub-category
            const val MAIN_CATEGORY = "Category"
            const val CHAILD_CATEGORY = "ChildCategories"

            //product
            const val PRODUCT_LIST = "Products"

            //filter
            const val VALUE = "Value"
            const val BRANDS = "Brands"
            const val COLORS = "Colors"
            const val MAX_PRICE = "MaxPrice"
            const val MIN_PRICE = "MinPrice"
            const val OTHER_ATTRIBUTE = "OtherAttributes"
            const val KEY = "Key"
            const val OTHER_VALUES = "Values"

            //product details
            const val PRODUCT_IAMGD_URL = "Img"
            const val PRODUCT_ID = "ProductID"
            const val COLOR_NAME = "String"
            const val COLOR_VALID = "Valid"
            const val SECOND_VALUE = "SecondValue"
            const val PRODUCT_ATTRIBUTE = "ProductAttributes"
            const val PRODUCT_ATTRIBUTE_KEY = "ProductAttrKeys"
            const val PRICE = "Price"
            const val PRODUCT_VERIATION = "ProductVariations"
            const val PRODUCT_VARIATION = "ProductVariation"
            const val RATING = "Rating"
            const val LONG_DESCRIPTION = "LongDescription"
            const val SPECIAL_FEATURE = "SpecialFeatures"
            const val PRODUCT_GALLERY = "ProductGalleries"

            //review
            const val FIRST_NAME = "FirstName"
            const val LAST_NAME = "LastName"
            const val COUNTRY_CODE = "CountryCode"
            const val PROFILE_PIC = "ProfilePic"
            const val COMMENT = "Comment"
            const val USER_ID = "UserID"
            const val PRODUCT_REVIEWS = "ProductReviews"
            const val REVIEW_DATE = "CreatedAt"

            //cart
            const val CART_ID = "CartID"
            const val CART_IMAGE_URL = "Image"
            const val TOTAL_PRODUCT = "TotalProduct"
            const val SUB_TOTAL = "SubTotal"
            const val TOTAL_DISCOUNT = "TotalDiscount"
            const val TOTAL_SHIPPING_COST = "TotalShippingCost"
            const val TOTAL_TAX = "TotalTax"
            const val GRAND_TOTAL = "GrandTotal"
            const val CART_PRODUCT = "CartProducts"
            const val FINAL_CART = "FinalCart"
            const val UNIT_PRICE = "UnitPrice"
            const val TOTAL_PRICE = "TotalPrice"
            const val DISCOUNT_PERCENT = "Discount"
            const val FLASH_DISCOUNT = "FlashDiscount"
            const val DISCOUNT_MAX = "DiscountMaxPrice"
            const val DISCOUNT_MIN = "DiscountMinPrice"

            //profile
            const val ROLE_ID = "RoleID"
            const val PROFILE_PICTURE = "ProfilePic"
            const val ORDER_COUNT = "OrderCount"
            const val DISTRICT = "District"
            const val POSTAL_CODE = "PostalCode"
            const val ADDRESS = "Address"
            const val BILLING_ADDRESS = "BillingAddress"

            //search
            const val BLOG_CATEGORIES = "BlogCategories"
            const val BLOGS = "Blogs"
            const val PRODUCT_CATEGORY = "ProductCategories"
            const val PRODUCTS = "Products"
            const val TYPE = "Type"
            const val ITEM_TYPE = "ItemType"

            const val LANGUAGE_CODE = "Code"
            const val LANGUAGE_NAME = "Name"
            const val LANGUAGES = "Languages"

            //order
            const val DATE_WISE_ORDER = "DateWiseOrders"
            const val DATE = "Date"
            const val ORDERS = "Orders"
            const val ORDER_BILL_ADDRESS = "OrderBillAddress"
            const val ORDER_DETAILS = "OrderDetails"
            const val ORDER_ID = "OrderID"
            const val CONVO_GRAND_TOTAL  = "ConvGrandTotal"
            const val CONVO_SYMBOL = "CheckoutCurrencySymbol"

            //blog
            const val BLOG_CATEGORY = "BlogCategories"
            const val BLOG_IMAGE_URL = "Image"
            const val BLOG_VIDEO_URL = "Video"
            const val BLOG_TOTAL_COMMENT = "TotalComments"
            const val CREATED_DATE = "CreatedDate"
            const val DETAILS = "Details"
            const val COMMENTS = "Comments"
            const val BLOG_CODE = "Code"
            const val PARENT_ID = "ParentID"
            const val CHILD_COMMENT = "ChildComments"
            const val CONVO_TOTAL_TAX = "ConvTotalTax"
            const val CONVO_SHIPPING_COST = "ConvTotalShippingCost"
            const val CONVO_DISCOUNT = "ConvTotalDiscount"
            const val CONV_TOTAL_PRICE = "ConvTotalPrice"
            const val BLOG_ID = "BlogCommentID"

            //payment
            const val PAYMENT = "payment"
            const val PAY_METHOD_ID = "pay_method_id"
            const val PAYMENT_METHOD = "PaymentMethods"
            const val METHOD = "Method"
            const val STATUS = "Status"
            const val BRAINTREE_CSE_KEY = "Braintree_CSE_Key"
            const val TOKEN_KEY = "Braintree_Tokenization_Key"
            const val MERCHANT_KEY = "Google_Pay_Merchant_ID"

        }
    }

    class PreferenceKeys {
        companion object {
            const val EMAIL = "email"
            const val IS_LOGGED_IN = "logged_in"
            const val ACCESS_TOKEN = "access_token"
            const val USER_MODEL = "user_model"
            const val USER_IMAGE = "user_image"
            const val REGISTRATION_TYPE = "typee"
            const val IS_SOCIAL_LOGIN = "social_type"
            const val LANGUAGE_CODE = "lan_code"
            const val CURRENCY_CODE = "cur_code"
            const val CURRENCY_SYMBOL = "cur_symbol"
            const val CONVERTED_UNIT = "convert_unit"
            const val CURRENCY_KEY = "currency_key"
            const val CART_ITEMS = "cart_item"
            const val ADDESS_MODE = "address"
            const val TOTAL_AMOUNT = "total"
            const val USER_ID = "user_id"
            const val IS_PUSH_NOTIFICATION_ON = "push_noti"
        }
    }

    class IntentKeys {
        companion object {
            const val CLINIC_ID = "clinic_id"
            const val SERVICE_ID = "service_id"
            const val MONTH_LIMIT = "month_limit"
            const val GET_EMAIL_RESEND = "email"
        }
    }

    class RandomKeys {
        companion object {
            const val TREAND_TYPE = 3
            const val CATEGORY_TYPE = 0
            const val FLASH_TYPE = 1
            const val NEW_ARRIVAL_TYPE = 2
            const val ALL_PRODUCT = 4
        }
    }

    class API {
        //end url
        companion object {
            const val REGISTER = "register"
            const val EMAIL_VERIFICATION = "email-verify"
            const val LOG_IN = "login"
            const val RESEND_EMAIL_VERIFICATION_CODE = "resend-email-verification"
            const val FORGOT_PASSWORD_EMAIL_SEND = "send-password-reset-code"
            const val RESET_PASSWORD = "reset-password"
            const val LOGOUT = "logout"
            const val HOME = "home"
            const val ADD_TO_WISHLIST = "add-to-wishlist"
            const val REMOVE_FROM_WISHLIST = "remove-from-wishlist"
            const val WISHLIST = "wishlist"
            const val CATEGORIES = "categories"
            const val SUB_CATEGORY = "sub-categories"
            const val SOCIAL_SIGN_IN = "social-login"
            const val PRODUCTS = "products"
            const val FILTERED_ITEMS = "filtering-items"
            const val FILTERED_PRODUCT = "filtered-products"
            const val PRODUCT_DETAILS = "product-details"
            const val GET_PRODUCT_REVIEW = "get-product-reviews"
            const val ADD_REVIEW = "add-product-review"
            const val ADD_TO_CART = "add-to-cart"
            const val CART_LIST = "show-cart"
            const val DELETE_CART = "remove-from-cart"
            const val UPDATE_CART = "update-cart"
            const val UPDATE_PROFILE_PICTURE = "update-profile-picture"
            const val UPDATE_PROFILE = "update-profile"
            const val GET_USER_PROFILE = "get-user-profile"
            const val CHANGE_PASSWORD = "change-password"
            const val SET_BILLING_ADDRESS = "set-billing-address"
            const val GET_BILLING_ADDRESS = "get-billing-address"
            const val SEARCH = "search"
            const val LANGUAGES = "languages"
            const val ORDER = "orders"
            const val BLOG_CATEGORY = "blog-categories"
            const val ARTICLE_LIST = "blogs"
            const val BLOG_DETAILS = "blog-details"
            const val ADD_BLOG_COMMENT = "add-blog-comment"
            const val PAYMENT_METHOD = "payment-methods"
            const val CHECK_OUT = "checkout"
            const val BRAINTREE = "braintree-credentials"
            const val UPDATE_BLOG_COMMENT = "update-blog-comment"
            const val DELETE_COMMENT = "delete-blog-comment"
        }

        class Header {
            companion object {
                const val CONTENT_TYPE = "Content-Type:application/x-www-form-urlencoded"
                const val AUTHORIZARION = ""
            }

            class Field {
                companion object {
                    const val CONTENT_VALUE = "application/json"
                    const val AUTHORIZATION = "Authorization"
                }
            }
        }

        class Body {
            class Field {
                //hit field
                companion object {
                    const val ID = "id"
                    const val TOKEN = "Token"
                    const val API_TOKEN = "App-Key"
                    const val LANGUAGE = "Lang"

                    //registration
                    const val EMAIL = "email"
                    const val FIRST_NAME = "first_name"
                    const val LAST_NAME = "last_name"
                    const val PASSWORD = "Password"
                    const val PHONE = "Phone"
                    const val ADDRESS_PHONE = "phone"
                    const val COUNTRY_CODE = "CountryCode"

                    //email verification
                    const val EMAIL_VERIFY_CODE = "EmailVerifyCode"

                    //reset password
                    const val RESET_EMAIL = "Email"
                    const val RESET_CODE = "Code"
                    const val NEW_PASSWORD = "NewPassword"

                    //add favourite
                    const val PRODUCT_ID = "ProductID"
                    const val PRODUCT_REMOVE_ID = "WishlistID"

                    const val CATEGORY_ID = "ID"
                    const val SOCIAL_AUTH_ID = "SocialAuthID"
                    const val REGISTRATION_TYPE = "RegType"

                    //product
                    const val PRODUCT_TYPE = "Type"
                    const val CATEGORY_P_ID = "CategoryID"
                    const val PAGE_NO = "PageNo"

                    //review
                    const val RATING = "Rating"
                    const val COMMENT = "Comment"

                    //cart
                    const val QUANTITY = "qty[]"
                    const val CART_ID = "CartID"
                    const val CART_QUANTITY = "Quantity"

                    //change password
                    const val OLD_PASSWORD = "OldPassword"

                    //address
                    const val ADDRESS_ID = "ID"
                    const val COUNTRY = "country"
                    const val DISTRICT = "district"
                    const val POSTAL_CODE = "postal_code"
                    const val ADDRESS = "address"
                    const val VALUE = "value"
                    const val TYPE = "Type"

                    const val STATUS = "Status"
                    const val BLOG_CATEGORY_ID = "BlogCategoryID"
                    const val BLOG_ID = "BlogID"
                    const val PARENT_ID = "ParentID"
                    const val LEVEL = "Level"

                    const val PAYMENT_TYPE = "payment"
                    const val PAYMENT_ID = "pay_method_id"
                    const val STRIPE_TOKEN = "stripeToken"
                    const val STRIPE_EMAIL = "stripeEmail"
                    const val CURRENCY_CODE = "currency_code"
                    const val CURRENCY_SYMBOL = "currency_symbol"
                    const val CONVERSION_RATE = "conversion_rate"
                    const val BRAINTREE_NONCE = "payment_method_nonce"
                    const val UPDATE_COMMENT = "comment"

                }
            }
        }
    }

    class ServerUrl {
        companion object {
            const val CURRENCY_URL = "https://free.currconv.com/api/"
            const val END_URL = "v7/convert?"
            const val CONVERT_INFO = "q"
            const val COMPACT = "compact"
            const val API_KEY = "apiKey"
        }
    }

}