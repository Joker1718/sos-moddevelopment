/*    */ package init.paths;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Path;
/*    */ import java.nio.file.attribute.FileAttribute;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ final class VanillaOnly extends PATH {
/*    */   private final VirtualFolder f;
/*    */   
/*    */   VanillaOnly(Path path, String filetype, boolean create) {
/* 14 */     super(filetype);
/* 15 */     if (create)
/* 16 */       Util.makeDirs(path); 
/* 17 */     ArrayList<Path> pp = new ArrayList(path);
/* 18 */     this.f = new VirtualFolder((LIST<Path>)pp, "");
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFiles() {
/* 23 */     return this.f.listFiles(this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFilesOrdered() {
/* 28 */     return this.f.listFilesOrdered(this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] folders() {
/* 33 */     return this.f.listFolders();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Path getRaw(CharSequence resource) {
/* 38 */     return this.f.getExistingFile(resource);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Path[] getRaws(CharSequence resource) {
/* 43 */     return this.f.getExistingFiles(resource);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void validate() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected PATH getFolder(CharSequence folder, String filetype, boolean create) {
/* 53 */     if (create) {
/* 54 */       Path p = this.f.getExistingFile(null).resolve(String.valueOf(folder));
/* 55 */       if (!Files.exists(p, new java.nio.file.LinkOption[0])) {
/*    */         try {
/* 57 */           Files.createDirectories(p, (FileAttribute<?>[])new FileAttribute[0]);
/* 58 */         } catch (IOException e) {
/* 59 */           e.printStackTrace();
/*    */         } 
/*    */       }
/*    */     } 
/*    */     
/* 64 */     return new VanillaOnly(this.f.getExistingFile(folder), filetype, create);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean exists(CharSequence file) {
/* 69 */     return this.f.exists(file, this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public Path get() {
/* 74 */     return this.f.getExistingFile(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean existsFolder(CharSequence folder) {
/* 79 */     return this.f.exists(folder, "");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean exists(CharSequence file, CharSequence fileType) {
/* 84 */     return this.f.exists(file, this.filetype);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\VanillaOnly.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */