/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRace;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Prices
/*     */   extends GuiSection
/*     */ {
/*     */   Prices() {
/* 204 */     final UIPickerRace pick = new UIPickerRace();
/* 205 */     pick.set((FACTIONS.player().race()).index);
/*     */     
/* 207 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 211 */           return TR.ALL().size();
/*     */         }
/*     */       };
/*     */     
/* 215 */     bu.column("", 24, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 219 */             return (RENDEROBJ)new RENDEROBJ.RenderImp(24)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/* 223 */                   ((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())).icon().render(r, (RECTANGLE)this.body);
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */     
/* 229 */     bu.column(Dic.¤¤Price, 120, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 233 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 237 */                   GFORMAT.i(text, FACTIONS.PRICE().get((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                 }
/* 239 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 245 */     bu.column(Dic.¤¤Rate, 120, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 249 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 253 */                   GFORMAT.f(text, 1.0D / (SETT.RECIPES()).ratesV.vanillaRate((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                 }
/* 255 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 259 */     if ((S.get()).developer) {
/* 260 */       bu.column("dRate", 120, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(final GETTER<Integer> ier)
/*     */             {
/* 264 */               return (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 268 */                     TRADABLE res = (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue());
/* 269 */                     double rr = 0.0D;
/* 270 */                     double p = 0.0D;
/* 271 */                     for (FactionNPC f : FACTIONS.NPCs()) {
/* 272 */                       p += f.citizens(null);
/* 273 */                       rr += f.res(res).rateTot() * f.citizens(null);
/*     */                     } 
/* 275 */                     rr /= p;
/* 276 */                     double r = (SETT.RECIPES()).ratesV.vanillaRate(res) / 1.0D / rr;
/* 277 */                     GFORMAT.f(text, r);
/*     */                   }
/* 279 */                 }).r(DIR.NW);
/*     */             }
/*     */           });
/*     */     }
/*     */     
/* 284 */     bu.column(String.valueOf(Dic.¤¤Rate) + " x " + String.valueOf(Dic.¤¤Rate), 120, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 288 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 292 */                   GFORMAT.f(text, FACTIONS.PRICE().get((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())) / (SETT.RECIPES()).ratesV.vanillaRate((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                 }
/* 294 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 298 */     bu.column(String.valueOf(Dic.¤¤Rate) + "*", 120, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 302 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 306 */                   GFORMAT.f(text, 1.0D / (SETT.RECIPES()).rates.rateTotal((BOOSTABLE_O)HCLASS_RACE.clP(pick.race()), (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                 }
/* 308 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 312 */     bu.column(String.valueOf(Dic.¤¤Rate) + " x " + String.valueOf(Dic.¤¤Rate) + "*", 120, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 316 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 320 */                   GFORMAT.f(text, FACTIONS.PRICE().get((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())) / (SETT.RECIPES()).rates.rateTotal((BOOSTABLE_O)HCLASS_RACE.clP(pick.race()), (TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue())));
/*     */                 }
/* 322 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */     
/* 326 */     add((RENDEROBJ)bu.create(16, true));
/*     */     
/* 328 */     addRelBody(16, DIR.N, (RENDEROBJ)pick.section);
/*     */     
/* 330 */     GText t = new GText((UI.FONT()).S, UITreasury.¤¤priceDesc);
/* 331 */     t.setMaxWidth(400);
/* 332 */     t.setMultipleLines(true);
/*     */ 
/*     */ 
/*     */     
/* 336 */     addRelBody(4, DIR.N, (SPRITE)t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\UITreasury$Prices.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */