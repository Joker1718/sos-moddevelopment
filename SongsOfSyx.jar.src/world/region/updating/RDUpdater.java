/*     */ package world.region.updating;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.updating.IUpdater;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RDUpdater
/*     */ {
/*     */   private final LIST<RD.RDUpdatable> all;
/*  23 */   private float[] timers = new float[1023];
/*     */   
/*  25 */   private final Shipper shipper = new Shipper();
/*  26 */   private final Builder builder = new Builder();
/*     */ 
/*     */   
/*  29 */   private final double upD = (TIME.secondsPerDay() / 4);
/*  30 */   private final double ship = TIME.secondsPerDay();
/*  31 */   private final double build = (TIME.secondsPerDay() * 2);
/*     */ 
/*     */   
/*     */   private final IUpdater uper;
/*     */ 
/*     */   
/*     */   public final SAVABLE saver;
/*     */ 
/*     */ 
/*     */   
/*     */   public RDUpdater(RD.RDInit init) {
/*  42 */     this.uper = new IUpdater(1023, 16.0D)
/*     */       {
/*     */ 
/*     */         
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/*  48 */           Region r = WORLD.REGIONS().getByIndex(i);
/*  49 */           if (r != null && r.active())
/*     */           {
/*     */ 
/*     */             
/*  53 */             if (r.faction() == FACTIONS.player()) {
/*  54 */               RDUpdater.this.timers[r.index()] = (float)(RDUpdater.this.timers[r.index()] + timeSinceLast);
/*  55 */               if (RDUpdater.this.timers[r.index()] > RDUpdater.this.ship) {
/*  56 */                 RDUpdater.this.shipper.ship(r, RDUpdater.this.ship);
/*  57 */                 RDUpdater.this.timers[r.index()] = (float)(RDUpdater.this.timers[r.index()] - RDUpdater.this.ship);
/*     */               } 
/*     */               
/*  60 */               for (RD.RDUpdatable u : RDUpdater.this.all)
/*  61 */                 u.update(r, timeSinceLast); 
/*     */             } else {
/*  63 */               float next = (float)(RDUpdater.this.timers[r.index()] + timeSinceLast);
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  68 */               if ((int)(RDUpdater.this.timers[r.index()] / RDUpdater.this.upD) != (int)(next / RDUpdater.this.upD))
/*  69 */                 for (RD.RDUpdatable u : RDUpdater.this.all) {
/*  70 */                   u.update(r, RDUpdater.this.upD);
/*     */                 } 
/*  72 */               if (next >= RDUpdater.this.build) {
/*  73 */                 if (r.faction() != null)
/*  74 */                   RDUpdater.this.builder.build(r); 
/*  75 */                 RDUpdater.this.shipper.ship(r, RDUpdater.this.build);
/*  76 */                 next = (float)(next - RDUpdater.this.build);
/*     */               } 
/*     */               
/*  79 */               RDUpdater.this.timers[r.index()] = next;
/*     */             } 
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  86 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  90 */           file.fs(RDUpdater.this.timers);
/*  91 */           RDUpdater.this.uper.save(file);
/*     */         }
/*     */         public void clear() {}
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  96 */           file.fs(RDUpdater.this.timers);
/*  97 */           RDUpdater.this.uper.load(file);
/*     */         }
/*     */       };
/*     */     this.all = (LIST<RD.RDUpdatable>)init.upers;
/*     */     for (int i = 0; i < this.timers.length; i++) {
/*     */       this.timers[i] = (float)(RND.rFloat() * this.build);
/*     */     }
/*     */   }
/*     */   
/*     */   public void update(double ds) {
/* 107 */     this.uper.update(ds);
/*     */   }
/*     */   
/*     */   public void BUILD(Region reg) {
/* 111 */     this.builder.build(reg);
/*     */   }
/*     */   
/*     */   public void BUILD(Region reg, RealmBuilder bu) {
/* 115 */     this.builder.build(reg, bu);
/*     */   }
/*     */   
/*     */   public void init(Region reg) {
/* 119 */     this.builder.build(reg);
/*     */   }
/*     */ 
/*     */   
/*     */   public void shipAll(Faction f, double days) {
/* 124 */     this.shipper.shipAll(f, days);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\RDUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */