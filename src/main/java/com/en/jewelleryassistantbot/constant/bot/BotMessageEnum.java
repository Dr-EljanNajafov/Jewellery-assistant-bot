package com.en.jewelleryassistantbot.constant.bot;

/**
 * Text messages sent by the jewelry store bot
 */
public enum BotMessageEnum {
    // Responses to keyboard commands
    HELP_MESSAGE("\uD83D\uDC4B Hello! I'm the Jewelry Assistant Bot. I can help you with:\n\n" +
            "❗ *What you can do:*\n" +
            "✅ View information about our stores\n" +
            "✅ Explore our jewelry collection\n" +
            "✅ Get contact details for our store\n\n" +
            "Feel free to use the keyboard below to navigate through the options.\n\n" +
            "If you need any assistance, just let me know!"),
    CHOOSE_OPTION_MESSAGE("Please choose an option from the menu \uD83D\uDC47"),
    UPLOAD_DOCUMENT_MESSAGE("Please upload the document according to the template. You can do this at any time."),
    NON_COMMAND_MESSAGE("Please use the keyboard to select a valid option \uD83D\uDC47"),

    // Results of actions
    SUCCESS_UPLOAD_MESSAGE("\uD83D\uDC4D Document successfully uploaded"),
    EXCEPTION_TELEGRAM_API_MESSAGE("Error attempting to retrieve file from Telegram API"),
    EXCEPTION_TOO_LARGE_DOCUMENT_MESSAGE("The document is too large. Please ensure it fits within the allowed size"),
    EXCEPTION_BAD_FILE_MESSAGE("The file cannot be processed. Please make sure it's in the correct format"),

    // Errors handling callbacks
    EXCEPTION_BAD_BUTTON_NAME_MESSAGE("Invalid button value. This is unexpected. Please try again later"),
    EXCEPTION_DOCUMENT_NOT_FOUND_MESSAGE("Document not found"),
    EXCEPTION_DOCUMENT_WTF_MESSAGE("Unexpected error occurred while retrieving the document"),
    EXCEPTION_JEWELRY_INFO_WTF_MESSAGE("Unexpected error occurred while retrieving jewelry information"),
    EXCEPTION_STORE_INFO_WTF_MESSAGE("Unexpected error occurred while retrieving store information"),
    EXCEPTION_CONTACT_INFO_WTF_MESSAGE("Unexpected error occurred while retrieving contact information"),

    // Product related errors
    EXCEPTION_PRODUCT_NOT_FOUND_MESSAGE("Product not found"),
    EXCEPTION_PRODUCT_WTF_MESSAGE("Unexpected error occurred while retrieving the product"),
    EXCEPTION_PRODUCT_LIST_MESSAGE("Unable to retrieve the list of products"),
    
    // Other errors
    EXCEPTION_ILLEGAL_MESSAGE("This input is not supported! I only handle specific commands or documents"),
    EXCEPTION_WHAT_THE_FUCK("Something went wrong. Please contact support");

    private final String message;

    BotMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
