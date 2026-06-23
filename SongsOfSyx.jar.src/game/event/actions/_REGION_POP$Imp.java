/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ import world.region.pop.RDRace;
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
/*    */ public final class Imp
/*    */   extends EventAction
/*    */ {
/*    */   private final LIST<Race> races;
/*    */   private final double amountRel;
/*    */   private final int amountAbs;
/*    */   private final EventAction.CInt amount;
/*    */   
/*    */   Imp(String key, Json data, LISTE<EventAction> all) {
/* 41 */     super(key, all);
/* 42 */     this.races = RACES.map().readMany(data);
/* 43 */     this.amountRel = data.dTry("AMOUNT_REL", -1.0D, 1.0D, 0.0D);
/* 44 */     this.amountAbs = data.i("AMOUNT_ABS", -2147483648, 2147483647, 0);
/* 45 */     this.amount = new EventAction.CInt(this, "AMOUNT");
/* 46 */     data.checkUnused();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setContext(Event event, EContext data) {
/* 52 */     this.amount.set(event, data, 0);
/* 53 */     for (Region reg : WORLD.REGIONS().active()) {
/* 54 */       if ((RD.event()).ii.get(reg) == 1) {
/* 55 */         for (Race rr : this.races) {
/* 56 */           RDRace r = RD.RACE(rr);
/* 57 */           if (r == null)
/*    */             continue; 
/* 59 */           int am = r.pop.get(reg);
/* 60 */           am = (int)(am * this.amountRel);
/* 61 */           am += this.amountAbs;
/* 62 */           this.amount.set(event, data, this.amount.get(event, data) + am);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void exe(Event event, EContext data) {
/* 73 */     for (Region reg : WORLD.REGIONS().active()) {
/* 74 */       if ((RD.event()).ii.get(reg) == 1) {
/* 75 */         for (Race rr : this.races) {
/* 76 */           RDRace r = RD.RACE(rr);
/* 77 */           if (r == null)
/*    */             continue; 
/* 79 */           int am = r.pop.get(reg);
/* 80 */           am = (int)(am * this.amountRel);
/* 81 */           am += this.amountAbs;
/* 82 */           r.pop.inc(reg, am);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addToMessageBody(LISTE<RENDEROBJ> rows, final Event event, final EContext data, RECTANGLE messBody) {
/* 92 */     rows.add((new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 96 */             GFORMAT.i(text, _REGION_POP.Imp.this.amount.get(event, data));
/*    */           }
/* 98 */         }).hh((SPRITE)(UI.icons()).s.death));
/*    */   }
/*    */   
/*    */   public void hover(GBox b, Event event, EContext context) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_REGION_POP$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */