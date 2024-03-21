Feature: sample karate test script

  Background:
    * configure retry = {count: 3, interval: 3000}

    * def FileUtils = Java.type('co.cobre.lib.qa.util.FileUtils')
    * def CommonUtils = Java.type('co.cobre.lib.qa.util.CommonUtils')
    * def CommonFuntion = Java.type('co.cobre.lib.qa.util.CommonFuntion')



  @regression
  Scenario Outline: Dado que se quiere Actualizar fecha de vencimiento por usuario
    # --------------------------------------------------------------- #
    * def File = Java.type('co.cobre.lib.qa.util.ProcessesIntheFile')
    * def mensaje = File.ModifyExpirationDate('<csvFilePath>','<Document>','<newExpirationDate>')
    * def newExpirationDate = File.getExpirationDate('<csvFilePath>','<Document>')
    * match newExpirationDate == '<newExpirationDate>'

    Examples:
      | Document |csvFilePath                                                        |newExpirationDate|
      |558432  |src/test/java/acceptance/test/recaudoTemplateCaracteresEspeciales.csv|2024-01-10       |