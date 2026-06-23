/*    */ package init.paths;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ final class Normal
/*    */   extends PATH
/*    */ {
/*    */   private final VirtualFolder f;
/*    */   
/*    */   Normal(String path, String filetype) {
/* 12 */     super(filetype);
/* 13 */     this.f = new VirtualFolder(PATHS.i.paths, path);
/*    */   }
/*    */   
/*    */   Normal(LIST<Path> roots, String path, String filetype) {
/* 17 */     super(filetype);
/* 18 */     this.f = new VirtualFolder(roots, path);
/*    */   }
/*    */   
/*    */   Normal(VirtualFolder f, String filetype) {
/* 22 */     super(filetype);
/* 23 */     this.f = f;
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFiles() {
/* 28 */     return this.f.listFiles(this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFilesOrdered() {
/* 33 */     return this.f.listFilesOrdered(this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] folders() {
/* 38 */     return this.f.listFolders();
/*    */   }
/*    */ 
/*    */   
/*    */   protected Path getRaw(CharSequence resource) {
/* 43 */     return this.f.getExistingFile(resource);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Path[] getRaws(CharSequence resource) {
/* 48 */     return this.f.getExistingFiles(resource);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void validate() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected PATH getFolder(CharSequence folder, String filetype, boolean create) {
/* 58 */     return new Normal(this.f.folder(folder), filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean exists(CharSequence file) {
/* 63 */     return this.f.exists(file, this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public Path get() {
/* 68 */     return this.f.getExistingFile(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean existsFolder(CharSequence folder) {
/* 73 */     return this.f.exists(folder, "");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean exists(CharSequence file, CharSequence fileType) {
/* 78 */     return this.f.exists(file, this.filetype);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\Normal.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */