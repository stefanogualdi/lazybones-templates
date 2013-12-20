def props = [:]

// Fixed properties
props["baseTemplatePath"]      = "wp-content/themes"
props["hostingHome"]           = "www"

// Base project
props["wordpressVersion"]      = ask("Define the wordpress version [3.7.1]: ", "3.7.1", "wordpressVersion")
props["wordpressTemplateName"] = ask("  Define the wp template name [base]: ", "base", "wordpressTemplateName")

props["wpTmplPath"] = props["baseTemplatePath"] + "/" + props["wordpressTemplateName"]

// FTP connection
props["hostingServer"]         = ask("Define the FTP server [ftp://server]: ", "ftp://server", "hostingServer")
props["hostingUsername"]       = ask("  Define the FTP username [username]: ", "username", "hostingUsername")
props["hostingPassword"]       = ask("  Define the FTP password [password]: ", "passsword", "hostingPassword")

// Customize properties
processTemplates("gitignore.tmpl", props)
processTemplates("wordpress.properties", props)
processTemplates("ftp.properties", props)
processTemplates("README.md", props)

// Create template dir, sass dir and initial sass file
new File(targetDir, "${props['wpTmplPath']}/sass").mkdirs()
new File(targetDir, "${props['wpTmplPath']}/sass/custom.scss").text = "/* Custom styles */\n\n"

// Rename the ignore definitons template
new File(targetDir, "gitignore.tmpl").renameTo(new File(targetDir, ".gitignore"))
