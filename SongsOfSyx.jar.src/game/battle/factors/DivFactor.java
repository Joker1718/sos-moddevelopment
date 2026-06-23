/*    */ package game.battle.factors;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.BValue;
/*    */ import game.boosting.BoostSpecs;
/*    */ import game.boosting.Boostable;
/*    */ import game.boosting.Booster;
/*    */ import game.boosting.BoosterValue;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.Player;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DivFactor
/*    */ {
/*    */   public final BSourceInfo info;
/*    */   public final CharSequence message;
/*    */   public final BoostSpecs specs;
/*    */   public final double midValue;
/*    */   private final BValue v;
/*    */   
/*    */   DivFactor(CharSequence name, CharSequence desc, SPRITE icon, CharSequence message, double mid) {
/* 62 */     this.v = new BValue()
/*    */       {
/*    */         public double vGet(Div div)
/*    */         {
/* 66 */           return DivFactor.this.getD(div);
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(Faction f) {
/* 71 */           return DivFactor.this.midValue;
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(Region reg) {
/* 76 */           return DivFactor.this.midValue;
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(Induvidual indu) {
/* 81 */           Div d = (Div)(STATS.BATTLE()).DIV.get(indu);
/* 82 */           if (d == null || !d.active())
/* 83 */             return DivFactor.this.induValue(indu); 
/* 84 */           return DivFactor.this.getD(d);
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(HCLASS_RACE popTime) {
/* 89 */           return DivFactor.this.midValue;
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(Player f) {
/* 94 */           return DivFactor.this.midValue;
/*    */         }
/*    */ 
/*    */         
/*    */         public double vGet(FactionNPC f) {
/* 99 */           return DivFactor.this.midValue;
/*    */         }
/*    */       };
/*    */     this.info = new BSourceInfo(name, desc, null, icon);
/*    */     this.message = message;
/*    */     this.specs = new BoostSpecs(this.info, true);
/*    */     this.midValue = mid;
/*    */     DivFactors.all.add(this);
/*    */   }
/*    */   
/*    */   public abstract double getD(Div paramDiv);
/*    */   
/*    */   public final void hover(Div div, GUI_BOX box) {
/*    */     GBox b = (GBox)box;
/*    */     b.title(this.info.name);
/*    */     b.text(this.info.desc);
/*    */     b.NL(4);
/*    */     phover(div, b);
/*    */     b.NL(8);
/*    */     this.specs.hoverDetailed((GUI_BOX)b, this.v.vGet(div), null, null, -1);
/*    */     b.NL();
/*    */   }
/*    */   
/*    */   protected void phover(Div div, GBox b) {}
/*    */   
/*    */   public DivFactor boost(Boostable b, double from, double to, boolean isMul) {
/*    */     this.specs.push((Booster)new BoosterValue(this.v, this.info, from, to, isMul), b);
/*    */     return this;
/*    */   }
/*    */   
/*    */   protected double induValue(Induvidual indu) {
/*    */     return this.midValue;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\DivFactor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */