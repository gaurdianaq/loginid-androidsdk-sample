# loginid-androidsdk-sample

ClientID and BaseURL should be stored as an environment variable in the format of ""yourkeyorbaseurlhere the double set of set of quotation marks is necessary because the string is being imported before the program even compiles. When an environment variable is imported as a string it removes the quotations, but since this is being put directly into generation java code it needs the extra set of quotations.