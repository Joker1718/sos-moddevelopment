/*     */ package init.paths;
/*     */ 
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class VirtualFolder
/*     */ {
/*     */   final LIST<Path> bases;
/*     */   private final String appendix;
/*     */   
/*     */   VirtualFolder(LIST<Path> bases, String path) {
/*  20 */     this.bases = bases;
/*  21 */     this.appendix = path;
/*  22 */     validate();
/*     */   }
/*     */ 
/*     */   
/*     */   private Path validate(Path path) {
/*  27 */     if (!Util.check(path)) {
/*  28 */       throw new Errors.DataError("This file/directory does not exist: " + String.valueOf(path), 
/*  29 */           path);
/*     */     }
/*     */     
/*  32 */     return path;
/*     */   }
/*     */ 
/*     */   
/*     */   private void validate() {
/*  37 */     for (Path p : this.bases) {
/*  38 */       Path f = resolve(p, null);
/*  39 */       if (Files.exists(f, new java.nio.file.LinkOption[0])) {
/*  40 */         if (!Files.isDirectory(f, new java.nio.file.LinkOption[0]))
/*  41 */           throw new Errors.DataError("This file is not a directory: .", 
/*  42 */               f.toAbsolutePath()); 
/*     */         return;
/*     */       } 
/*     */     } 
/*  46 */     Path path = resolve((Path)this.bases.get(this.bases.size() - 1), null);
/*  47 */     throw new Errors.DataError("This file/directory does not exist: " + String.valueOf(path), 
/*  48 */         path);
/*     */   }
/*     */ 
/*     */   
/*     */   VirtualFolder folder(CharSequence next) {
/*  53 */     if (this.appendix == null || this.appendix.length() <= 1) {
/*  54 */       return new VirtualFolder(this.bases, String.valueOf(next) + String.valueOf(next));
/*     */     }
/*  56 */     return new VirtualFolder(this.bases, this.appendix + this.appendix + PATHS.s);
/*     */   }
/*     */ 
/*     */   
/*     */   Path getExistingFile(CharSequence name) {
/*  61 */     Path p = getPossibleFile(name);
/*  62 */     if (p == null)
/*  63 */       throw new Errors.DataError("This resource could not be found: ", resolve((Path)this.bases.get(this.bases.size() - 1), String.valueOf(name))); 
/*  64 */     return p;
/*     */   }
/*     */ 
/*     */   
/*     */   Path[] getExistingFiles(CharSequence name) {
/*  69 */     if (name == null)
/*  70 */       name = ""; 
/*  71 */     String r = String.valueOf(name);
/*     */     
/*  73 */     int am = 0;
/*     */     
/*  75 */     for (Path root : this.bases) {
/*  76 */       Path p = resolve(root, r);
/*  77 */       if (Files.exists(p, new java.nio.file.LinkOption[0])) {
/*  78 */         am++;
/*     */       }
/*     */     } 
/*     */     
/*  82 */     Path[] pps = new Path[am];
/*  83 */     am = 0;
/*     */     
/*  85 */     for (Path root : this.bases) {
/*  86 */       Path p = resolve(root, r);
/*  87 */       if (Files.exists(p, new java.nio.file.LinkOption[0])) {
/*  88 */         validate(p);
/*  89 */         pps[am++] = p;
/*     */       } 
/*     */     } 
/*  92 */     if (am == 0)
/*  93 */       throw new Errors.DataError("This resource could not be found: ", resolve((Path)this.bases.get(this.bases.size() - 1), String.valueOf(name))); 
/*  94 */     return pps;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean exists(CharSequence file, CharSequence filetype) {
/*  99 */     String f = String.valueOf(file) + String.valueOf(file);
/* 100 */     for (Path m : this.bases) {
/* 101 */       if (Util.check(resolve(m, f)))
/* 102 */         return true; 
/*     */     } 
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   Path getPossibleFile(CharSequence name) {
/* 108 */     if (name == null)
/* 109 */       name = ""; 
/* 110 */     String r = String.valueOf(name);
/*     */     
/* 112 */     for (Path root : this.bases) {
/* 113 */       Path p = resolve(root, r);
/* 114 */       if (Files.exists(p, new java.nio.file.LinkOption[0])) {
/* 115 */         validate(p);
/* 116 */         return p;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 121 */     return null;
/*     */   }
/*     */   
/*     */   private Path resolve(Path base, String resource) {
/* 125 */     if (this.appendix.length() > 1)
/* 126 */       base = base.resolve(this.appendix); 
/* 127 */     if (resource == null || resource.length() == 0)
/* 128 */       return base; 
/*     */     try {
/* 130 */       return base.resolve(resource);
/* 131 */     } catch (Exception e) {
/* 132 */       e.printStackTrace();
/* 133 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   String[] listFiles(String ending) {
/* 140 */     if (ending.length() <= 1) {
/* 141 */       throw new RuntimeException();
/*     */     }
/* 143 */     HashSet<String> map = new HashSet<>();
/* 144 */     boolean ignore = false;
/* 145 */     for (int i = 0; i < this.bases.size(); i++) {
/* 146 */       Path m = (Path)this.bases.get(i);
/* 147 */       if (i == this.bases.size() - 1) {
/* 148 */         if (ignore)
/*     */           continue; 
/*     */       } else {
/* 151 */         ignore |= checkIgnore(resolve(m, null));
/*     */       }  byte b; int j; String[] arrayOfString;
/* 153 */       for (j = (arrayOfString = list(resolve(m, null), ending)).length, b = 0; b < j; ) { String s = arrayOfString[b];
/* 154 */         map.add(s);
/*     */         
/*     */         b++; }
/*     */       
/*     */       continue;
/*     */     } 
/* 160 */     String[] all = new String[map.size()];
/* 161 */     map.toArray(all);
/* 162 */     Arrays.sort((Object[])all);
/*     */     
/* 164 */     return all;
/*     */   }
/*     */ 
/*     */   
/*     */   String[] listFilesOrdered(String ending) {
/* 169 */     if (ending.length() <= 1) {
/* 170 */       throw new RuntimeException();
/*     */     }
/* 172 */     HashSet<String> map = new HashSet<>();
/* 173 */     for (int i = 0; i < this.bases.size(); i++) {
/* 174 */       Path m = (Path)this.bases.get(i); byte b; int n; String[] arrayOfString;
/* 175 */       for (n = (arrayOfString = list(resolve(m, null), ending)).length, b = 0; b < n; ) { String s = arrayOfString[b];
/* 176 */         map.add(s);
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/*     */     
/* 182 */     String[] all = new String[map.size()];
/* 183 */     map.clear();
/* 184 */     int k = 0;
/* 185 */     for (int j = 0; j < this.bases.size(); j++) {
/* 186 */       Path m = (Path)this.bases.get(j); byte b; int n; String[] arrayOfString;
/* 187 */       for (n = (arrayOfString = list(resolve(m, null), ending)).length, b = 0; b < n; ) { String s = arrayOfString[b];
/* 188 */         if (!map.contains(s)) {
/* 189 */           map.add(s);
/* 190 */           all[k++] = s;
/*     */         } 
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 196 */     return all;
/*     */   }
/*     */ 
/*     */   
/*     */   String[] listFolders() {
/* 201 */     HashSet<String> map = new HashSet<>();
/*     */     
/* 203 */     for (int i = 0; i < this.bases.size(); i++) {
/* 204 */       Path m = resolve((Path)this.bases.get(i), null);
/* 205 */       String sep = m.getFileSystem().getSeparator();
/* 206 */       for (Path p : Util.listFiles(m)) {
/* 207 */         if (Files.isDirectory(p, new java.nio.file.LinkOption[0])) {
/* 208 */           String s = String.valueOf(p.getFileName());
/* 209 */           if (s.startsWith("_"))
/*     */             continue; 
/* 211 */           if (s.endsWith(sep)) {
/* 212 */             s = s.substring(0, s.length() - sep.length());
/*     */           }
/* 214 */           map.add(s);
/*     */         } 
/*     */       } 
/* 217 */       if (checkIgnore(resolve(m, null))) {
/*     */         break;
/*     */       }
/*     */     } 
/* 221 */     String[] all = new String[map.size()];
/* 222 */     map.toArray(all);
/* 223 */     Arrays.sort((Object[])all);
/*     */     
/* 225 */     return all;
/*     */   }
/*     */   
/*     */   private boolean checkIgnore(Path path) {
/* 229 */     path = path.resolve("_IgnoreVanilla.txt");
/* 230 */     return Files.exists(path, new java.nio.file.LinkOption[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String[] list(Path path, String ending) {
/* 235 */     if (!Files.exists(path, new java.nio.file.LinkOption[0]))
/* 236 */       return new String[0]; 
/* 237 */     if (!Files.isDirectory(path, new java.nio.file.LinkOption[0])) {
/* 238 */       throw new Errors.DataError("This file should be a directory, but is not...", 
/* 239 */           String.valueOf(path));
/*     */     }
/*     */ 
/*     */     
/* 243 */     LinkedList<String> res = new LinkedList();
/*     */     
/* 245 */     for (Path p : Util.listFiles(path)) {
/*     */       
/* 247 */       String s = String.valueOf(p.getFileName());
/* 248 */       res.add(s);
/*     */     } 
/* 250 */     return clean(0, ending, 0, res);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] clean(int index, String ending, int size, LinkedList<String> origional) {
/* 256 */     int am = 0;
/* 257 */     for (String s : origional) {
/* 258 */       if (getClean(s, ending) != null)
/* 259 */         am++; 
/* 260 */     }  String[] res = new String[am];
/* 261 */     am = 0;
/* 262 */     for (String s : origional) {
/* 263 */       String c = getClean(s, ending);
/* 264 */       if (c != null)
/* 265 */         res[am++] = c; 
/*     */     } 
/* 267 */     return res;
/*     */   }
/*     */   
/*     */   private static String getClean(String s, String ending) {
/* 271 */     if (s.charAt(0) == '_')
/* 272 */       return null; 
/* 273 */     if (ending != null && !s.endsWith(ending))
/* 274 */       return null; 
/* 275 */     return s.substring(0, s.length() - ending.length());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\VirtualFolder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */