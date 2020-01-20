package com.itechsofsolutions.tictactoe.utils.libs


/**
 * This is a singleton class that contains utils for Google Pay
 * @author Mohd. Asfaq-E-Azam Rifat
 * */
/*object GooglePayUtil {

    const val EXAMPLE_MERCHANT_NAME = "Example Merchant"
    const val EXAMPLE_GATEWAY = "example"
    const val EXAMPLE_GATEWAY_MERCHANT_ID = "exampleMerchantId"
    private const val REQUEST_CODE_LOAD_PAYMENT_DATA = 1

    private var mGateway: String = EXAMPLE_GATEWAY
    private var mGatewayMerchantId: String = EXAMPLE_GATEWAY_MERCHANT_ID
    private var mPaymentListener: PaymentListener? = null

    private val mBaseRequest: JSONObject
        @Throws(JSONException::class)
        get() = JSONObject()
                .put("apiVersion", 2)
                .put("apiVersionMinor", 0)

    private val mTokenizationSpecification: JSONObject
        @Throws(JSONException::class)
        get() {
            val tokenizationSpecification = JSONObject()
            tokenizationSpecification.put("type", "PAYMENT_GATEWAY")
            tokenizationSpecification.put(
                    "parameters",
                    JSONObject()
                            .put("gateway", mGateway)
                            .put("gatewayMerchantId", mGatewayMerchantId))

            return tokenizationSpecification
        }

    private val mAllowedCardNetworks: JSONArray
        get() = JSONArray()
                .put("AMEX")
                .put("DISCOVER")
                .put("JCB")
                .put("MASTERCARD")
                .put("VISA")

    private val mAllowedCardAuthMethods: JSONArray
        get() = JSONArray()
                .put("PAN_ONLY")
                .put("CRYPTOGRAM_3DS")

    private val mBaseCardPaymentMethod: JSONObject
        @Throws(JSONException::class)
        get() {
            val mCardPaymentMethod = JSONObject()
            mCardPaymentMethod.put("type", "CARD")
            mCardPaymentMethod.put(
                    "parameters",
                    JSONObject()
                            .put("allowedAuthMethods", mAllowedCardAuthMethods)
                            .put("allowedCardNetworks", mAllowedCardNetworks))

            return mCardPaymentMethod
        }

    private val mCardPaymentMethod: JSONObject
        @Throws(JSONException::class)
        get() {
            val mCardPaymentMethod = mBaseCardPaymentMethod
            mCardPaymentMethod.put("tokenizationSpecification", mTokenizationSpecification)

            return mCardPaymentMethod
        }

    private val isReadyToPayRequest: JSONObject
        @Throws(JSONException::class)
        get() {
            val isReadyToPayRequest = mBaseRequest
            isReadyToPayRequest.put(
                    "allowedPaymentMethods",
                    JSONArray().put(mBaseCardPaymentMethod))

            return isReadyToPayRequest
        }

    @Throws(JSONException::class)
    private fun getTransactionInfo(price: String, currencyCode: String): JSONObject {
        val mTransactionInfo = JSONObject()
        mTransactionInfo.put("totalPrice", price)
        mTransactionInfo.put("totalPriceStatus", "FINAL")
        mTransactionInfo.put("currencyCode", currencyCode)

        return mTransactionInfo
    }

    @Throws(JSONException::class)
    private fun getMerchantInfo(merchantName: String): JSONObject {
        return JSONObject().put("merchantName", merchantName)
    }

    @Throws(JSONException::class)
    private fun getPaymentRequest(gateway: String, gatewayMerchantId: String,
                                  price: String, currencyCode: String,
                                  merchantName: String): JSONObject {

        val paymentDataRequest = mBaseRequest

        mGateway = gateway
        mGatewayMerchantId = gatewayMerchantId

        paymentDataRequest.put("allowedPaymentMethods", JSONArray().put(mCardPaymentMethod))
        paymentDataRequest.put("transactionInfo", getTransactionInfo(price, currencyCode))
        paymentDataRequest.put("merchantInfo", getMerchantInfo(merchantName))

        return paymentDataRequest
    }

    private fun getPaymentClient(activity: Activity, isTestEnvironment: Boolean): PaymentsClient {
        return Wallet.getPaymentsClient(activity, Wallet.WalletOptions.Builder()
                .setEnvironment(
                        if (isTestEnvironment) {
                            WalletConstants.ENVIRONMENT_TEST
                        } else {
                            WalletConstants.ENVIRONMENT_PRODUCTION
                        })
                .build())
    }

    *//**
     * This method is to pay a price via GooglePay
     *
     * N.B: Please @see [onActivityResult]. Put it under the current [Activity.onActivityResult]
     *
     * @param activity current activity
     * @param isTestEnvironment if the environment is for testing
     * @param price required price
     * @param currencyCode required currency code
     * @param merchantName name of the merchant
     * @param gateway payment gateway
     * @param gatewayMerchantId id of the merchant gateway
     * @param paymentListener listener to get states
     * *//*
    fun pay(activity: Activity,
            isTestEnvironment: Boolean,
            price: String,
            currencyCode: String,
            merchantName: String,
            gateway: String,
            gatewayMerchantId: String,
            paymentListener: PaymentListener?) {

        mPaymentListener = paymentListener
        var request: PaymentDataRequest? = null
        val paymentRequest = getPaymentRequest(gateway, gatewayMerchantId, price,
                currencyCode, merchantName)

        try {
            request = PaymentDataRequest.fromJson(paymentRequest.toString())
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        if (request != null) {
            val paymentsClient = getPaymentClient(activity, isTestEnvironment)

            paymentsClient.let {
                AutoResolveHelper.resolveTask(
                        it.loadPaymentData(request),
                        activity,
                        REQUEST_CODE_LOAD_PAYMENT_DATA
                )
            }
        }
    }

    *//**
     * This method post-processes the returned data and send to the listener
     *
     * @param requestCode request code
     * @param resultCode result code
     * @param data intent with data
     * *//*
  *//*  fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE_LOAD_PAYMENT_DATA -> when (resultCode) {
                Activity.RESULT_OK -> {
                    data?.let {
                        // Handle success state
                        val paymentData = PaymentData.getFromIntent(it)
                        paymentData?.let { data ->
                            val json = data.toJson()

                            val paymentMethodData = JSONObject(json)
                                    .getJSONObject("paymentMethodData")

                            val paymentToken = paymentMethodData
                                    .getJSONObject("tokenizationData")
                                    .getString("token")

                            mPaymentListener?.onSuccess(paymentToken)
                            mPaymentListener = null
                        }
                    }
                }
                Activity.RESULT_CANCELED -> {
                    // Handle cancelled state
                    mPaymentListener?.onCancel(data)
                    mPaymentListener = null
                }
                AutoResolveHelper.RESULT_ERROR -> {
                    // Handle error state
                    val status = AutoResolveHelper.getStatusFromIntent(data)
                    mPaymentListener?.onError(status)
                    mPaymentListener = null
                }
            }
        }
    }*//*

    *//**
     * This method let the user know if Google pay is ready to pay
     *
     * @param activity current activity
     * @param isTestEnvironment if the environment is for testing
     * @param listener listener to get state
     * *//*
  *//*  fun isReadyToPay(activity: Activity, isTestEnvironment: Boolean, listener: IsReadyListener?) {
        IsReadyToPayRequest.fromJson(isReadyToPayRequest.toString()).let {
            getPaymentClient(activity, isTestEnvironment).isReadyToPay(it).let { task ->
                task.addOnCompleteListener { completedTask ->
                    try {
                        var result = false
                        val resultObject = completedTask.getResult(ApiException::class.java)

                        if (resultObject != null) {
                            result = resultObject
                        }

                        listener?.onCheck(result)
                    } catch (ignored: ApiException) {
                        listener?.onCheck(false)
                    }
                }
            }
        }
    }*//*

    interface PaymentListener {
        fun onSuccess(token: String?)
        fun onError(status: AsyncTask.Status?)
        fun onCancel(data: Intent?)
    }

    interface IsReadyListener {
        fun onCheck(isReady: Boolean)
    }
}*/
