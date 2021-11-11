This application can be used to send emails with text and subject to all emails in a database.
Use emailText.txt to right the text that you want to send.
Use subjectText.txt to right the subject that you want to send.
Use db.properties to configure the database in mySql.
Configure in EmailSenderConfiguration class "mail.smtp.host","mail.smtp.port", "mail.smtp.auth","mail.smtp.starttls.enable" of your email provider 
the one that i tested was from gmail.
Use set method form email class to set up email and password in EmailSenderConfiguration in the static block.
