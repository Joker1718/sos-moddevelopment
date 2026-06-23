/*     */ package util.race;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ 
/*     */ public interface PERMISSION {
/*     */   boolean get(HCLASS paramHCLASS, Race paramRace);
/*     */   
/*     */   void set(HCLASS paramHCLASS, Race paramRace, boolean paramBoolean);
/*     */   
/*     */   default void toggle(HCLASS cl, Race race) {
/*  23 */     set(cl, race, !get(cl, race));
/*     */   }
/*     */   default boolean get(Induvidual indu) {
/*  26 */     return get(indu.clas(), indu.race());
/*     */   }
/*     */   default boolean has(Humanoid h) {
/*  29 */     return get(h.indu());
/*     */   }
/*     */   
/*     */   INFO info();
/*     */   
/*     */   public static class Permission
/*     */     implements PERMISSION, SAVABLE {
/*  36 */     private static CharSequence ¤¤name = "¤Permission";
/*  37 */     private static CharSequence ¤¤desc = "¤Toggle permission";
/*     */     static {
/*  39 */       D.ts(PERMISSION.class);
/*     */     }
/*     */     
/*  42 */     private final Bitmap1D access = new Bitmap1D(RACES.all().size() * HCLASSES.ALL().size(), false);
/*     */     private boolean def = false;
/*     */     private final INFO info;
/*     */     
/*     */     public Permission(INFO info) {
/*  47 */       this.info = info;
/*     */     }
/*     */     
/*     */     public Permission(CharSequence name, CharSequence desc) {
/*  51 */       this.info = new INFO(name, desc);
/*     */     }
/*     */     
/*     */     public Permission() {
/*  55 */       this.info = new INFO(¤¤name, ¤¤desc);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean get(HCLASS cl, Race race) {
/*  62 */       if (race == null) {
/*  63 */         for (Race r : RACES.all()) {
/*  64 */           if (get(cl, r))
/*  65 */             return true; 
/*     */         } 
/*  67 */         return false;
/*     */       } 
/*  69 */       return this.access.get(cl.index() * RACES.all().size() + race.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(HCLASS cl, Race race, boolean value) {
/*  74 */       if (race == null) {
/*  75 */         for (Race r : RACES.all()) {
/*  76 */           set(cl, r, value);
/*     */         }
/*     */       } else {
/*  79 */         this.access.set(cl.index() * RACES.all().size() + race.index, value);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public INFO info() {
/*  85 */       return this.info;
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/*  90 */       this.access.save(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/*  95 */       this.access.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 100 */       this.access.setAll(this.def);
/*     */     }
/*     */     
/*     */     public void setDef(boolean def) {
/* 104 */       this.def = def;
/* 105 */       clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\race\PERMISSION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */