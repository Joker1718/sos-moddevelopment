/*    */ package game.audio;
/*    */ 
/*    */ import init.paths.PATH;
/*    */ import init.paths.PathParser;
/*    */ import java.nio.file.Path;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ public abstract class AudioFactory<T>
/*    */ {
/* 15 */   private final KeyMap<T> map = new KeyMap();
/* 16 */   protected final LinkedList<T> all = new LinkedList();
/*    */   private final PATH path;
/*    */   private final T DUMMY;
/*    */   private final ArrayList<T> LDUMMY;
/*    */   private final String key;
/*    */   private final String split;
/*    */   
/*    */   protected AudioFactory(String key, PATH path, T DUMMY) {
/* 24 */     this.path = path;
/* 25 */     this.LDUMMY = new ArrayList(DUMMY);
/* 26 */     this.key = key;
/*    */ 
/*    */     
/* 29 */     String pp = String.valueOf(path.get().toAbsolutePath());
/*    */     
/* 31 */     this.split = String.valueOf(pp.subSequence(pp.lastIndexOf("audio"), pp.length()));
/* 32 */     this.DUMMY = DUMMY;
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<T> create(String[] paths, Json json, String jsonKey) {
/* 37 */     LinkedList<T> res = new LinkedList(); byte b; int i;
/*    */     String[] arrayOfString;
/* 39 */     for (i = (arrayOfString = paths).length, b = 0; b < i; ) { String relPath = arrayOfString[b];
/* 40 */       if (relPath.equals("DUMMY")) {
/* 41 */         res.add((Iterable)this.LDUMMY);
/*    */       } else {
/* 43 */         LIST<Path> pps = PathParser.getMany(this.path, relPath, json, jsonKey);
/* 44 */         if (pps == null || pps.size() == 0) {
/* 45 */           res.add((Iterable)this.LDUMMY);
/*    */         } else {
/* 47 */           for (Path p : pps) {
/* 48 */             String pn = String.valueOf(p.toAbsolutePath());
/* 49 */             String kk = String.valueOf(pn.subSequence(pn.lastIndexOf(this.split) + this.split.length() + 1, pn.length()));
/* 50 */             if (!this.map.containsKey(kk)) {
/* 51 */               T e = create(this.all, p, kk);
/* 52 */               this.all.add(e);
/* 53 */               this.map.put(kk, e);
/*    */             } 
/* 55 */             res.add(this.map.get(kk));
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       
/*    */       b++; }
/*    */     
/* 62 */     return (LIST<T>)new ArrayList((Iterable)res);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LIST<T> read(Json json) {
/* 69 */     return read(this.key, json);
/*    */   }
/*    */   
/*    */   public LIST<T> read(String key, Json json) {
/* 73 */     if (!json.has(key))
/* 74 */       return (LIST<T>)this.LDUMMY; 
/* 75 */     if (json.arrayIs(key))
/* 76 */       return create(json.values(key), json, key); 
/* 77 */     return create(new String[] { json.value(key) }, json, key);
/*    */   }
/*    */   
/*    */   public LIST<T> all() {
/* 81 */     return (LIST<T>)this.all;
/*    */   }
/*    */   
/*    */   public KeyMap<T> map() {
/* 85 */     return this.map;
/*    */   }
/*    */   
/*    */   public final T DUMMY() {
/* 89 */     return this.DUMMY;
/*    */   }
/*    */   
/*    */   public LIST<T> LDUMMY() {
/* 93 */     return (LIST<T>)this.LDUMMY;
/*    */   }
/*    */   
/*    */   protected abstract T create(LinkedList<T> paramLinkedList, Path paramPath, String paramString);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\audio\AudioFactory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */