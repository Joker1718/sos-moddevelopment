/*     */ package init.paths;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.attribute.FileAttribute;
/*     */ import snake2d.Errors;
/*     */ 
/*     */ public abstract class PATH
/*     */ {
/*     */   protected final String filetype;
/*     */   
/*     */   PATH(String filetype) {
/*  14 */     this.filetype = filetype;
/*     */   }
/*     */   
/*     */   public Path get(CharSequence resource) {
/*  18 */     if (this.filetype.equals(PATHS.s))
/*  19 */       return getRaw(resource); 
/*  20 */     if (String.valueOf(resource).endsWith(this.filetype))
/*  21 */       return getRaw(resource); 
/*  22 */     return getRaw(String.valueOf(resource) + String.valueOf(resource));
/*     */   }
/*     */   
/*     */   public Path[] gets(CharSequence resource) {
/*  26 */     if (this.filetype.equals(PATHS.s))
/*  27 */       return getRaws(resource); 
/*  28 */     if (String.valueOf(resource).endsWith(this.filetype))
/*  29 */       return getRaws(resource); 
/*  30 */     return getRaws(String.valueOf(resource) + String.valueOf(resource));
/*     */   }
/*     */   
/*     */   public Path getLikeHell(CharSequence resource) {
/*  34 */     return getRaw(resource);
/*     */   }
/*     */   
/*     */   public Path[] getLikeHells(CharSequence resource) {
/*  38 */     return getRaws(resource);
/*     */   }
/*     */   
/*     */   protected abstract Path getRaw(CharSequence paramCharSequence);
/*     */   
/*     */   protected abstract Path[] getRaws(CharSequence paramCharSequence);
/*     */   
/*     */   public final PATH getFolder(CharSequence folder) {
/*  46 */     return getFolder(folder, this.filetype);
/*     */   }
/*     */   
/*     */   public PATH getFolder(CharSequence folder, String filetype) {
/*  50 */     return getFolder(folder, filetype, false);
/*     */   }
/*     */   
/*     */   protected abstract PATH getFolder(CharSequence paramCharSequence, String paramString, boolean paramBoolean);
/*     */   
/*     */   protected PATH getFolder(CharSequence folder, boolean create) {
/*  56 */     return getFolder(folder, this.filetype, create);
/*     */   }
/*     */   
/*     */   public abstract Path get();
/*     */   
/*     */   public Path create(CharSequence file) {
/*  62 */     Path p = get().resolve(String.valueOf(file) + String.valueOf(file));
/*     */     try {
/*  64 */       Files.deleteIfExists(p);
/*  65 */       Files.createFile(p, (FileAttribute<?>[])new FileAttribute[0]);
/*  66 */     } catch (IOException e) {
/*  67 */       e.printStackTrace();
/*  68 */       throw new Errors.DataError("Unable to process file", String.valueOf(p));
/*     */     } 
/*     */     
/*  71 */     return p;
/*     */   }
/*     */   
/*     */   public void delete(CharSequence file) {
/*  75 */     Path p = get().resolve(String.valueOf(file) + String.valueOf(file));
/*     */     try {
/*  77 */       Files.deleteIfExists(p);
/*  78 */     } catch (IOException e) {
/*  79 */       e.printStackTrace();
/*  80 */       throw new Errors.DataError("Unable to delete file", String.valueOf(p));
/*     */     } 
/*     */   }
/*     */   
/*     */   public abstract boolean exists(CharSequence paramCharSequence);
/*     */   
/*     */   public abstract boolean exists(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
/*     */   
/*     */   public abstract boolean existsFolder(CharSequence paramCharSequence);
/*     */   
/*     */   public abstract String[] getFiles();
/*     */   
/*     */   public abstract String[] getFilesOrdered();
/*     */   
/*     */   public String[] getFiles(int min) {
/*  95 */     String[] ss = getFiles();
/*  96 */     if (ss.length < min)
/*  97 */       throw new Errors.DataError("insufficient files declared. Needs at least " + min, String.valueOf(get())); 
/*  98 */     return ss;
/*     */   }
/*     */   
/*     */   public String[] getFiles(int min, int max) {
/* 102 */     String[] ss = getFiles();
/* 103 */     if (ss.length < min)
/* 104 */       throw new Errors.DataError("insufficient files declared. Needs at least " + min, String.valueOf(get())); 
/* 105 */     if (ss.length > max) {
/* 106 */       throw new Errors.DataError("too many files declared. Max is: " + max, String.valueOf(get()));
/*     */     }
/* 108 */     return ss;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract String[] folders();
/*     */   
/*     */   public String fileEnding() {
/* 115 */     return this.filetype;
/*     */   }
/*     */   
/*     */   protected abstract void validate();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\PATH.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */