/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.tourism.TOURISM;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class StatsGovern
/*     */   extends StatCollection
/*     */ {
/*     */   public final STAT tourismFriend;
/*     */   public final STAT tourismEnemy;
/*     */   public final STAT RICHES;
/*  28 */   private static CharSequence ¤¤name = "Government";
/*  29 */   private static CharSequence ¤¤desc = "Government stats";
/*     */   
/*     */   static {
/*  32 */     D.ts(StatsGovern.class);
/*     */   }
/*     */   
/*     */   public StatsGovern(StatsInit init) {
/*  36 */     super(init, "GOVERN", ¤¤name, ¤¤desc);
/*     */     
/*  38 */     this.tourismFriend = (STAT)new STATFakeRace("TOURISM_FRIEND", init)
/*     */       {
/*     */         protected double getDD(Race r)
/*     */         {
/*  42 */           double res = 0.0D;
/*  43 */           double tot = 0.0D;
/*  44 */           for (Race other : RACES.all()) {
/*  45 */             tot += TOURISM.race(other);
/*  46 */             res += TOURISM.race(other) * r.pref().race(other);
/*     */           } 
/*  48 */           if (tot == 0.0D) {
/*  49 */             return 0.0D;
/*     */           }
/*  51 */           return res / tot;
/*     */         }
/*     */       };
/*  54 */     (this.tourismFriend.info()).icon = (SPRITE)(UI.icons()).m.citizen;
/*     */     
/*  56 */     this.tourismEnemy = (STAT)new STATFakeRace("TOURISM_ENEMY", init)
/*     */       {
/*     */         
/*     */         protected double getDD(Race r)
/*     */         {
/*  61 */           double res = 0.0D;
/*  62 */           double tot = 0.0D;
/*  63 */           for (Race other : RACES.all()) {
/*  64 */             tot += TOURISM.race(other);
/*  65 */             res += TOURISM.race(other) * (1.0D - r.pref().race(other));
/*     */           } 
/*  67 */           if (tot == 0.0D) {
/*  68 */             return 0.0D;
/*     */           }
/*  70 */           return (int)(res / tot);
/*     */         }
/*     */       };
/*     */     
/*  74 */     (this.tourismEnemy.info()).icon = (SPRITE)(UI.icons()).m.citizen.twin((SPRITE)(UI.icons()).m.anti);
/*     */     
/*  76 */     this.RICHES = (STAT)new STATFakeRace("RICHES", init)
/*     */       {
/*     */         
/*     */         protected double getDD(Race r)
/*     */         {
/*  81 */           int pop = (POP.tot(HCLASSES.CITIZEN(), null) + POP.tot(HCLASSES.NOBLE(), null)) * 400 * 4;
/*  82 */           double d = FACTIONS.player().credits().credits();
/*  83 */           if (pop == 0) {
/*  84 */             return ((d > 0.0D) ? true : false);
/*     */           }
/*  86 */           return d / pop;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX text, HCLASS cl, Race type) {
/*  91 */           GBox b = (GBox)text;
/*  92 */           b.NL();
/*  93 */           b.textLL(Dic.¤¤Currs);
/*  94 */           int tot = (POP.tot(HCLASSES.CITIZEN(), null) + POP.tot(HCLASSES.NOBLE(), null)) * 400 * 4;
/*  95 */           b.add((SPRITE)GFORMAT.iofk(b.text(), (int)FACTIONS.player().credits().credits(), tot));
/*  96 */           b.NL();
/*  97 */           super.hover(text, cl, type);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 103 */     this.RICHES.info().setMatters(true, false);
/* 104 */     (this.RICHES.info()).icon = (SPRITE)(UI.icons()).m.coins;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsGovern.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */