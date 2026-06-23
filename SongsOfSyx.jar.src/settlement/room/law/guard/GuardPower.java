/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ public class GuardPower
/*     */   implements SAVABLE
/*     */ {
/*     */   private Div d;
/*     */   
/*  25 */   private final DIV_SPEC spec = new DIV_SPEC()
/*     */     {
/*     */       public Race race()
/*     */       {
/*  29 */         return GuardPower.this.d.race();
/*     */       }
/*     */ 
/*     */       
/*     */       public double training(StatsBattle.StatTraining tr) {
/*  34 */         return tr.stat.div().getD(GuardPower.this.d);
/*     */       }
/*     */ 
/*     */       
/*     */       public double equip(EquipBattle e) {
/*  39 */         return CLAMP.d(e.stat().div().get(GuardPower.this.d) / STATS.POP().pop(HTYPES.SOLDIER(), GuardPower.this.d), 0.0D, 1.0D);
/*     */       }
/*     */ 
/*     */       
/*     */       public int men() {
/*  44 */         return STATS.POP().pop(HTYPES.GUARD(), GuardPower.this.d);
/*     */       }
/*     */ 
/*     */       
/*     */       public Faction faction() {
/*  49 */         return (Faction)FACTIONS.player();
/*     */       }
/*     */ 
/*     */       
/*     */       public double experience() {
/*  54 */         return (STATS.BATTLE()).COMBAT_EXPERIENCE.div().getD(GuardPower.this.d);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public CharSequence name() {
/*  60 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public int bannerI() {
/*  66 */         return 0;
/*     */       }
/*     */     };
/*     */   
/*  70 */   private double res = 0.0D;
/*  71 */   private double resD = 0.0D;
/*  72 */   private int upI = -1;
/*  73 */   private int DI = 0;
/*     */   
/*     */   public double get() {
/*  76 */     if (this.upI == GAME.updateI())
/*  77 */       return this.res; 
/*  78 */     this.upI = GAME.updateI();
/*  79 */     if (this.DI >= GAME.ARMIES().player().divisions().size()) {
/*  80 */       this.DI = 0;
/*  81 */       this.res = this.resD;
/*  82 */       this.resD = 0.0D;
/*     */     } 
/*     */     
/*  85 */     Div d = (Div)GAME.ARMIES().player().divisions().get(this.DI);
/*  86 */     if ((SETT.ROOMS()).GUARD.activeDuty.is(d) && STATS.POP().pop(HTYPES.GUARD(), d) > 0) {
/*  87 */       this.d = d;
/*  88 */       this.resD += (GAME.battle()).power.get(this.spec);
/*     */     } 
/*  90 */     this.DI++;
/*     */     
/*  92 */     return this.res;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  97 */     file.d(this.res);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 102 */     this.res = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 107 */     this.res = 0.0D;
/* 108 */     this.resD = 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\GuardPower.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */