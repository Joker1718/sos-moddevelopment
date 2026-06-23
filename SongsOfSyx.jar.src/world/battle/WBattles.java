/*     */ package world.battle;
/*     */ 
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WBattles
/*     */   extends WORLD.WorldResource
/*     */ {
/*     */   public static final double retreatPenalty = 0.4D;
/*     */   private final PRegAttack regAttack;
/*     */   private final PFieldBattle poller;
/*     */   private final PSiege siege;
/*     */   private final WORLD.WorldResourceManager saver;
/*     */   
/*     */   public WBattles() {
/*  24 */     super("battles", "BATTLES");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  39 */     this.saver = new WORLD.WorldResourceManager()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  43 */           WBattles.this.regAttack.save(file);
/*  44 */           WBattles.this.poller.save(file);
/*  45 */           WBattles.this.siege.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  50 */           WBattles.this.regAttack.load(file);
/*  51 */           WBattles.this.poller.load(file);
/*  52 */           WBattles.this.siege.load(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/*  57 */           WBattles.this.regAttack.clear();
/*  58 */           WBattles.this.poller.clear();
/*  59 */           WBattles.this.siege.clear(); } };
/*     */     Util u = new Util();
/*     */     Side.Conflict c = new Side.Conflict();
/*     */     Resolver pro = new Resolver();
/*     */     this.regAttack = new PRegAttack(c, pro, u);
/*     */     this.poller = new PFieldBattle(c, pro, u);
/*  65 */     this.siege = new PSiege(u, c, pro); } public WORLD.WorldResourceManager saver() { return this.saver; }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds, Profiler prof) {
/*  70 */     prof.logStart(this);
/*  71 */     this.siege.update(ds);
/*  72 */     prof.logEnd(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void poll() {
/*  77 */     int death = 0;
/*  78 */     while (canPoll() && 
/*  79 */       this.regAttack.poll()) {
/*     */       
/*  81 */       if (death++ > 1000) {
/*  82 */         throw new RuntimeException();
/*     */       }
/*     */     } 
/*  85 */     death = 0;
/*  86 */     while (canPoll() && 
/*  87 */       this.poller.poll()) {
/*     */       
/*  89 */       if (death++ > 1000) {
/*  90 */         throw new RuntimeException();
/*     */       }
/*     */     } 
/*  93 */     death = 0;
/*  94 */     while (canPoll() && 
/*  95 */       this.siege.poll()) {
/*     */       
/*  97 */       if (death++ > 1000) {
/*  98 */         throw new RuntimeException();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean canPoll() {
/* 105 */     return (!VIEW.b().isActive() && !(VIEW.world()).UI.battle.isBusty());
/*     */   }
/*     */   
/*     */   public double besigedTime(Region reg) {
/* 109 */     return this.siege.besigedTime(reg);
/*     */   }
/*     */   
/*     */   public boolean besiged(Region reg) {
/* 113 */     return this.siege.besiged(reg);
/*     */   }
/*     */   
/*     */   public void besige(WArmy a, Region reg) {
/* 117 */     this.siege.besige(a, reg);
/*     */   }
/*     */   
/*     */   public void regAttack(Region reg, WArmy a) {
/* 121 */     this.regAttack.regAttack(reg, a);
/* 122 */     report(a);
/*     */   }
/*     */   
/*     */   public void report(WArmy a) {
/* 126 */     this.regAttack.register(a);
/* 127 */     this.poller.register(a);
/* 128 */     this.siege.register(a);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\WBattles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */