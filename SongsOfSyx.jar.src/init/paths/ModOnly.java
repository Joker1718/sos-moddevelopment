/*    */ package init.paths;
/*    */ 
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ final class ModOnly
/*    */   extends PATH {
/*    */   private final VirtualFolder f;
/*    */   
/*    */   ModOnly(String path, String filetype, boolean create) {
/* 12 */     super(filetype);
/*    */     
/* 14 */     Path p = (Path)PATHS.i.paths.get(0);
/* 15 */     if (PATHS.currentMods().size() == 0)
/* 16 */       p = (Path)PATHS.i.paths.get(PATHS.i.paths.size() - 1); 
/* 17 */     if (create)
/* 18 */       Util.makeDirs(p.resolve(path)); 
/* 19 */     this.f = new VirtualFolder((LIST<Path>)new ArrayList(p), path);
/*    */   }
/*    */   
/*    */   ModOnly(String patha, String path, String filetype, boolean create) {
/* 23 */     super(filetype);
/*    */     
/* 25 */     Path p = (Path)PATHS.i.paths.get(0);
/* 26 */     if (PATHS.currentMods().size() == 0)
/* 27 */       p = (Path)PATHS.i.paths.get(PATHS.i.paths.size() - 1); 
/* 28 */     if (create)
/* 29 */       Util.makeDirs(p.resolve(path)); 
/* 30 */     this.f = new VirtualFolder((LIST<Path>)new ArrayList(p), path);
/*    */   }
/*    */   
/*    */   private ModOnly(VirtualFolder f, String filetype) {
/* 34 */     super(filetype);
/* 35 */     this.f = f;
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFiles() {
/* 40 */     return this.f.listFiles(this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] getFilesOrdered() {
/* 45 */     return this.f.listFilesOrdered(this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] folders() {
/* 50 */     return this.f.listFolders();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Path getRaw(CharSequence resource) {
/* 56 */     return this.f.getExistingFile(resource);
/*    */   }
/*    */ 
/*    */   
/*    */   protected Path[] getRaws(CharSequence resource) {
/* 61 */     return this.f.getExistingFiles(resource);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void validate() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected PATH getFolder(CharSequence folder, String filetype, boolean create) {
/* 72 */     if (create) {
/* 73 */       Path p = get();
/* 74 */       Util.makeDirs(p.resolve(String.valueOf(folder)));
/*    */     } 
/* 76 */     return new ModOnly(this.f.folder(folder), filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean exists(CharSequence file) {
/* 81 */     return this.f.exists(file, this.filetype);
/*    */   }
/*    */ 
/*    */   
/*    */   public Path get() {
/* 86 */     return this.f.getExistingFile(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean existsFolder(CharSequence folder) {
/* 91 */     return this.f.exists(folder, "");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean exists(CharSequence file, CharSequence fileType) {
/* 96 */     return this.f.exists(file, fileType);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\ModOnly.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */