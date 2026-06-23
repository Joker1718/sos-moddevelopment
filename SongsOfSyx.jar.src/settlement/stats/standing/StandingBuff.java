/*     */ package settlement.stats.standing;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public class StandingBuff
/*     */ {
/*  28 */   private static CharSequence ¤¤Emmergency = "Emergency";
/*     */   
/*     */   static {
/*  31 */     D.ts(StandingBuff.class);
/*     */   }
/*     */   
/*  34 */   public final double time = (TIME.secondsPerDay() * 8);
/*  35 */   public final double timerI = 1.0D / this.time;
/*  36 */   public final double add = 1.0D;
/*  37 */   private double[] timer = new double[HCLASSES.ALL().size()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  80 */     for (int i = 0; i < HCLASSES.ALL().size(); i++) {
/*  81 */       this.timer[i] = CLAMP.d(this.timer[i] - ds, 0.0D, this.time * 4.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public void execute(HCLASS cl, double time) {
/*  86 */     this.timer[cl.index()] = Math.max(this.timer[cl.index()], time);
/*     */   }
/*     */   
/*  89 */   public StandingBuff() { this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  93 */           file.dsE(StandingBuff.this.timer);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/*  98 */           file.dsE(StandingBuff.this.timer); }
/*     */         public double vGet(FactionNPC f) { return 0.0D; } public double vGet(Player f) { return vGet(HCLASS_RACE.clP()); } public double vGet(Div div) { return 0.0D; }
/*     */       };
/*     */     BValue v = new BValue()
/*     */       {
/* 103 */         public void clear() { Arrays.fill(StandingBuff.this.timer, 0.0D); }
/*     */         public double vGet(Induvidual indu) { return CLAMP.d(StandingBuff.this.timer[(indu.hType()).CLASS.index()] * StandingBuff.this.timerI, 0.0D, 1.0D); }
/*     */         public double vGet(Region reg) { return 0.0D; } public double vGet(HCLASS_RACE t) { if (t.cl != null)
/*     */             return CLAMP.d(StandingBuff.this.timer[t.cl.index()] * StandingBuff.this.timerI, 0.0D, 1.0D);  return 0.0D; }
/*     */       };
/* 108 */     (new BoosterValue(v, new BSourceInfo(¤¤Emmergency, (SPRITE)(UI.icons()).s.alert), 1.0D, false)).addRet((BOOSTABLES.BEHAVIOUR()).LOYALTY).add((BOOSTABLES.BEHAVIOUR()).SUBMISSION); } public static void fakeLoad(FileGetter file) throws IOException { file.dsE(new double[HCLASSES.ALL().size()]); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\standing\StandingBuff.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */