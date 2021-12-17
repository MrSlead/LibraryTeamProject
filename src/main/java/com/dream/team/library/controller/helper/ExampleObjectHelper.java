package com.dream.team.library.controller.helper;

public class ExampleObjectHelper {
       public static class GetById {
           public static final String CODE_400 = "{\"status\": \"ERROR\", \"result\": null, \"errors\": [{\"code\": \"400\", \"message\": \"The passed parameter is null\"}]}";
           public static final String CODE_404 = "{\"status\": \"ERROR\", \"result\": null, \"errors\": [{\"code\": \"404\", \"message\": \"The object by id not found\"}]}";
       }

       public static class GetAllBy {
           public static final String CODE_400 = "{\"status\": \"ERROR\", \"result\": null, \"errors\": [{\"code\": \"400\", \"message\": \"The passed object is null, or is empty\"}]}";
       }

       public static class Save {
           public static final String CODE_400 = "{\"status\": \"ERROR\", \"result\": null, \"errors\": [{\"code\": \"400\", \"message\": \"The passed object is null, or it has id\"}]}";
       }

       public static class Update {
           public static final String CODE_400 = "{\"status\": \"ERROR\", \"result\": null, \"errors\": [{\"code\": \"400\", \"message\": \"The passed object is null, or it has no id, or it not contained in the database\"}]}";
       }
}
