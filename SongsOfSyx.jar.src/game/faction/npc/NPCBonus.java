/*     */ package game.faction.npc;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DOUBLE_O;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public final class NPCBonus
/*     */   extends NPCResource implements DOUBLE_O<Boostable> {
/*  22 */   private final int MM = 127;
/*  23 */   private final double[] bos = new double[128];
/*     */   
/*     */   public final FactionNPC faction;
/*     */   
/*     */   public NPCBonus(final FactionNPC faction, LISTE<NPCResource> all) {
/*  28 */     super(all);
/*  29 */     randomize();
/*  30 */     this.faction = faction;
/*  31 */     if (faction.index() == 5) {
/*  32 */       IDebugPanel.add("Faction bonus max test", new ACTION()
/*     */           {
/*     */             
/*     */             public void exe()
/*     */             {
/*  37 */               double[] back = new double[128]; int i;
/*  38 */               for (i = 0; i < NPCBonus.this.bos.length; i++) {
/*  39 */                 back[i] = NPCBonus.this.bos[i];
/*  40 */                 NPCBonus.this.bos[i] = 1.0D;
/*     */               } 
/*     */               
/*  43 */               for (Boostable b : BOOSTING.ALL()) {
/*  44 */                 LOG.ln(b.key + " " + b.key);
/*     */               }
/*     */               
/*  47 */               for (i = 0; i < NPCBonus.this.bos.length; i++) {
/*  48 */                 NPCBonus.this.bos[i] = back[i];
/*     */               }
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getD(Boostable bo) {
/*  59 */     return get(bo.index());
/*     */   }
/*     */   
/*     */   public void clear() {
/*  63 */     for (int i = 0; i < this.bos.length; i++) {
/*  64 */       this.bos[i] = 0.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public double get(int ran) {
/*  69 */     int ii = ran & 0x7F;
/*  70 */     if (this.faction.court().king() == null || this.faction.court().king().roy() == null)
/*  71 */       return this.bos[ii] * 0.5D; 
/*  72 */     double c = 0.5D + 0.25D * (BOOSTABLES.NOBLE()).COMPETANCE.get((BOOSTABLE_O)(this.faction.court().king().roy()).induvidual);
/*  73 */     return CLAMP.d(this.bos[ii] * c, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public void randomize() {
/*     */     int i;
/*  78 */     for (i = 0; i < this.bos.length; i++) {
/*  79 */       this.bos[i] = 0.1D + 0.9D * i / (this.bos.length - 1);
/*  80 */       this.bos[i] = CLAMP.d(this.bos[i], 0.0D, 1.0D);
/*     */     } 
/*     */     
/*  83 */     for (i = 0; i < this.bos.length; i++) {
/*  84 */       double d = this.bos[i];
/*  85 */       int k = RND.rInt(this.bos.length);
/*  86 */       this.bos[i] = this.bos[k];
/*  87 */       this.bos[k] = d;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected SAVABLE saver() {
/*  94 */     return new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  98 */           file.ds(NPCBonus.this.bos);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 103 */           file.ds(NPCBonus.this.bos);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void clear() {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(FactionNPC faction, double seconds) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generate(RDRace race, FactionNPC faction, boolean fromScratch) {
/* 121 */     randomize();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\NPCBonus.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */