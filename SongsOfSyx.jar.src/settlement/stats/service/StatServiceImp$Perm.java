/*     */ package settlement.stats.service;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.data.BOOLEANO;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Perm
/*     */   implements BOOLEANO.BOOLEAN_OE<HCLASS_RACE>, SAVABLE
/*     */ {
/*  79 */   private final Bitmap1D access = new Bitmap1D(HCLASS_RACE.ALL().size(), false);
/*     */   private final INFO info;
/*     */   
/*     */   public Perm(CharSequence name, CharSequence desc) {
/*  83 */     this.info = new INFO(name, desc);
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/*  88 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  93 */     this.access.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  98 */     this.access.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 103 */     for (HCLASS_RACE p : HCLASS_RACE.ALL()) {
/* 104 */       if (StatServiceImp.this instanceof StatServiceChild)
/* 105 */         this.access.set(p.index, true); 
/* 106 */       if (p.cl != null && p.race != null) {
/* 107 */         boolean b = (p.cl != HCLASSES.SLAVE() && (StatServiceImp.this.total()).boosters.all().size() > 0);
/* 108 */         int i = b | ((StatServiceImp.this.total().standing().max(p.cl, p.race) != 0.0D) ? 1 : 0);
/* 109 */         this.access.set(p.index, !(i != 0));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is(HCLASS_RACE t) {
/* 116 */     if (t.race == null) {
/* 117 */       boolean m = false;
/* 118 */       for (Race r : RACES.all()) {
/* 119 */         m |= is(t.cl.get(r));
/*     */       }
/* 121 */       return m;
/*     */     } 
/* 123 */     return !this.access.get(t.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public BOOLEANO.BOOLEAN_OE<HCLASS_RACE> set(HCLASS_RACE t, boolean b) {
/* 128 */     if (t.race == null) {
/* 129 */       for (Race r : RACES.all()) {
/* 130 */         set(t.cl.get(r), b);
/*     */       }
/*     */     } else {
/* 133 */       this.access.set(t.index(), !b);
/* 134 */     }  return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceImp$Perm.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */