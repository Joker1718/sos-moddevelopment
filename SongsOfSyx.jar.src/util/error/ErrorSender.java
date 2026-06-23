/*     */ package util.error;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import snake2d.LOG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ErrorSender
/*     */ {
/*     */   public static void main(String[] args) throws Exception {
/*  21 */     (new ErrorSender()).send("babababa", "hello there", "dasdafsdfs\n \tdasdas");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  26 */     LOG.ln("POST DONE");
/*     */   }
/*     */   
/*     */   public boolean send(String key, String message, String out) throws Exception {
/*  30 */     URL obj = new URL("https://gamebugs-f058.restdb.io/rest/bugs");
/*  31 */     HttpURLConnection con = (HttpURLConnection)obj.openConnection();
/*  32 */     con.setRequestMethod("POST");
/*  33 */     con.setRequestProperty("Accept", "*/*");
/*  34 */     con.setRequestProperty("x-apikey", "60599d5bff8b0c1fbbc28dfb");
/*  35 */     con.setRequestProperty("Content-Type", "application/json");
/*     */     
/*  37 */     String code = "\"" + key + "\"";
/*     */ 
/*     */     
/*  40 */     message = message.replaceAll("\\t", " ");
/*  41 */     message = message.replaceAll("\\r\\n|\\r|\\n", " ");
/*     */ 
/*     */     
/*  44 */     message = "\"" + message + "\"";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     out = out.replaceAll("\\t", " ");
/*  51 */     String[] ss = out.split("\\r\\n|\\r|\\n");
/*  52 */     out = "[";
/*  53 */     for (int i = 0; i < ss.length; i++) {
/*  54 */       out = out + out;
/*  55 */       if (i < ss.length - 1) {
/*  56 */         out = out + ", ";
/*     */       }
/*     */     } 
/*  59 */     out = out + "]";
/*     */ 
/*     */ 
/*     */     
/*  63 */     LOG.ln(code);
/*     */     
/*  65 */     LOG.ln(message);
/*     */ 
/*     */     
/*  68 */     LOG.ln(out);
/*     */     
/*  70 */     String body = "{\"key\": " + 
/*  71 */       code + ",\"message\": " + 
/*  72 */       message + ",\"dump\": " + 
/*  73 */       out + "}";
/*     */ 
/*     */     
/*  76 */     LOG.ln();
/*  77 */     LOG.ln(body);
/*     */     
/*  79 */     byte[] bs = body.getBytes(StandardCharsets.UTF_8);
/*     */     
/*  81 */     con.setRequestProperty("charset", "utf-8");
/*  82 */     con.setRequestProperty("Content-Length", Integer.toString(bs.length));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  87 */     con.setDoOutput(true);
/*  88 */     OutputStream os = con.getOutputStream();
/*  89 */     os.write(bs);
/*  90 */     os.flush();
/*  91 */     os.close();
/*     */ 
/*     */     
/*  94 */     int responseCode = con.getResponseCode();
/*  95 */     LOG.ln("POST Response Code :: " + responseCode);
/*     */     
/*  97 */     if (responseCode == 201) {
/*  98 */       BufferedReader in = new BufferedReader(new InputStreamReader(
/*  99 */             con.getInputStream()));
/*     */       
/* 101 */       StringBuffer response = new StringBuffer();
/*     */       String inputLine;
/* 103 */       while ((inputLine = in.readLine()) != null) {
/* 104 */         response.append(inputLine);
/*     */       }
/* 106 */       in.close();
/* 107 */       LOG.ln(response.toString());
/* 108 */       return true;
/*     */     } 
/* 110 */     LOG.ln("POST request not worked");
/* 111 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String toHex(String out) {
/* 117 */     byte[] bs = out.getBytes(StandardCharsets.UTF_8);
/* 118 */     StringBuilder str = new StringBuilder();
/* 119 */     for (int i = 0; i < bs.length; i++) {
/* 120 */       str.append(String.format("%x", new Object[] { Byte.valueOf(bs[i]) }));
/*     */     } 
/* 122 */     out = "\"" + str.toString() + "\"";
/* 123 */     LOG.ln(out);
/* 124 */     return out;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\error\ErrorSender.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */