/*     */ package settlement.stats.equip;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ import util.text.D;
/*     */ 
/*     */ public class EquipCivic
/*     */   extends Equip {
/*  22 */   private final RMapInt.RMapIntTwo<HCLASS, Race> tars = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map());
/*  23 */   static CharSequence ¤¤more = "We would like to be allowed to wear more {0}.";
/*     */   
/*     */   static {
/*  26 */     D.ts(EquipCivic.class);
/*     */   }
/*     */   
/*     */   EquipCivic(String key, PATH path, LISTE<Equip> all, LISTE<EquipCivic> type, StatsInit init) {
/*  30 */     super("CIVIC", key, path, all, init);
/*  31 */     type.add(this);
/*     */     
/*  33 */     for (HCLASS cl : HCLASSES.ALL()) {
/*  34 */       for (Race race : RACES.all()) {
/*  35 */         this.tars.get((MAPPED)cl).set((MAPPED)race, this.targetDefault);
/*     */       }
/*     */     } 
/*     */     
/*  39 */     this.stat.info().setOpinion(¤¤more, null);
/*     */     
/*  41 */     SAVABLE sa = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  45 */           EquipCivic.this.tars.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  50 */           EquipCivic.this.tars.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  55 */           EquipCivic.this.tars.setAll(EquipCivic.this.targetDefault);
/*     */         }
/*     */       };
/*  58 */     sa.clear();
/*     */     
/*  60 */     init.savers.put(key + "_TAR", sa);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int target(Induvidual h) {
/*  66 */     return CLAMP.i(this.tars.get((MAPPED)h.clas()).get((MAPPED)h.race()), 0, max());
/*     */   }
/*     */   
/*     */   public int target(HCLASS c, Race type) {
/*  70 */     if (type == null) {
/*  71 */       int m = 0;
/*  72 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  73 */         Race r = (Race)RACES.all().get(ri);
/*  74 */         m = Math.max(m, target(c, r));
/*     */       } 
/*  76 */       return m;
/*     */     } 
/*  78 */     return CLAMP.i(this.tars.get((MAPPED)c).get((MAPPED)type), 0, max());
/*     */   }
/*     */   
/*     */   public void targetSet(int target, HCLASS c, Race type) {
/*  82 */     if (type == null) {
/*  83 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  84 */         Race r = (Race)RACES.all().get(ri);
/*  85 */         targetSet(target, c, r);
/*     */       } 
/*     */       return;
/*     */     } 
/*  89 */     target = CLAMP.i(target, 0, this.equipMax);
/*  90 */     this.tars.get((MAPPED)c).set((MAPPED)type, target);
/*     */   }
/*     */ 
/*     */   
/*     */   public int max() {
/*  95 */     return this.equipMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Induvidual i) {
/* 100 */     return this.equipMax;
/*     */   }
/*     */ 
/*     */   
/*     */   public double bValue(double equipped) {
/* 105 */     return equipped;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipCivic.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */