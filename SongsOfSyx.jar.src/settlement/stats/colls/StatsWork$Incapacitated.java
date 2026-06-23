/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.data.DataO;
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
/*     */ public final class Incapacitated
/*     */ {
/*     */   private final DataO<Induvidual>.DataAbs data;
/* 594 */   private final int[] htypes = Alloc.ii(HTYPES.ALL().size());
/* 595 */   private final int[] etypes = Alloc.ii(HTYPES.ALL().size() * RACES.all().size());
/*     */   
/*     */   public final STAT stat;
/*     */   
/*     */   private Incapacitated(StatsInit init) {
/* 600 */     init.count.getClass(); this.data = (DataO<Induvidual>.DataAbs)new DataO<Induvidual>.DataBit(init.count, "WORK_INCA")
/*     */       {
/*     */         public void set(Induvidual t, int s) {
/* 603 */           if (t.added()) {
/* 604 */             StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] - get(t);
/* 605 */             StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] - get(t);
/*     */           } 
/* 607 */           super.set(t, s);
/* 608 */           if (t.added()) {
/* 609 */             StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] + get(t);
/* 610 */             StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] + get(t);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 615 */     init.addable.add(new StatsInit.Addable()
/*     */         {
/*     */           public void removePrivate(Induvidual t)
/*     */           {
/* 619 */             StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] - StatsWork.Incapacitated.this.data.get(t);
/* 620 */             StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] - StatsWork.Incapacitated.this.data.get(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public void addPrivate(Induvidual t) {
/* 625 */             StatsWork.Incapacitated.this.htypes[t.hType().index()] = StatsWork.Incapacitated.this.htypes[t.hType().index()] + StatsWork.Incapacitated.this.data.get(t);
/* 626 */             StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] = StatsWork.Incapacitated.this.etypes[t.hType().index() * RACES.all().size() + (t.race()).index] + StatsWork.Incapacitated.this.data.get(t);
/*     */           }
/*     */         });
/*     */     
/* 630 */     init.savers.put("work_incap", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void clear() {
/* 646 */             Arrays.fill(StatsWork.Incapacitated.this.htypes, 0);
/*     */           }
/*     */         });
/*     */     
/* 650 */     this.stat = (STAT)new STATData("INCAPACITATED", init, this.data);
/*     */   }
/*     */ 
/*     */   
/*     */   public int get(HTYPE t) {
/* 655 */     return this.htypes[t.index()];
/*     */   }
/*     */   
/*     */   public int get() {
/* 659 */     return get(HTYPES.SUBJECT()) + get(HTYPES.SLAVE());
/*     */   }
/*     */   
/*     */   public int get(HTYPE t, Race race) {
/* 663 */     if (race == null)
/* 664 */       return get(t); 
/* 665 */     return this.etypes[t.index() * RACES.all().size() + race.index];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsWork$Incapacitated.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */