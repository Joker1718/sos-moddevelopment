/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BHoverer;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ class ArmyInfo
/*     */   extends GuiSection
/*     */ {
/*  36 */   private static CharSequence ¤¤MoraleDesc = "Morale is gained by keeping the army well supplied and by winning battles. Morale affects your army's performance on the battlefield.";
/*  37 */   private static CharSequence ¤¤HealthDesc = "Health is gained by keeping the army well supplied. Poor health will lead to desertion.";
/*     */   
/*  39 */   private static CharSequence ¤¤CreditsD = "The amount of money needed to upkeep this army daily.";
/*     */   static {
/*  41 */     D.ts(ArmyInfo.class);
/*     */   }
/*     */   
/*     */   public static GuiSection info(final GETTER<WArmy> army) {
/*  45 */     GuiSection ss = new GuiSection();
/*     */     
/*  47 */     ss.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  51 */             GFORMAT.i(text, AD.men(null).get(army.get()));
/*     */           }
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  55 */             b.title(Dic.¤¤Soldiers);
/*  56 */             b.add((SPRITE)GFORMAT.iofkInv(b.text(), AD.men(null).get(army.get()), AD.menTarget(null).get(army.get())));
/*     */           }
/*  60 */         }).hh((SPRITE)(SPRITES.icons()).s.human));
/*     */     
/*  62 */     ss.addRightC(80, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  66 */             ((WArmy)army.get()).state().info((WArmy)army.get(), text);
/*  67 */             text.lablifySub();
/*     */           }
/*  69 */         }).r(DIR.NW));
/*     */     
/*  71 */     ss.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  75 */             GFORMAT.perc(text, AD.supplies().health((WArmy)army.get()));
/*     */           }
/*  77 */         }).hh((SPRITE)(SPRITES.icons()).s.pluses).hoverTitleSet(Dic.¤¤Health).hoverInfoSet(¤¤HealthDesc), 0, ss.body().y2() + 2);
/*     */     
/*  79 */     ss.addRightC(80, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  83 */             GFORMAT.percInc(text, AD.morale((WArmy)army.get()), 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  88 */             b.title(Dic.¤¤Morale);
/*  89 */             b.text(ArmyInfo.¤¤MoraleDesc);
/*  90 */             b.sep();
/*  91 */             BHoverer.hoverDetailed((GUI_BOX)b, (LIST)AD.moraleFactors(), army.get(), Dic.¤¤Factors, 1.0D, true);
/*     */           }
/*  94 */         }).hh((SPRITE)(SPRITES.icons()).s.standard));
/*     */     
/*  96 */     ss.addRightC(80, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 100 */             GFORMAT.i(text, (int)(GAME.battle()).power.get((WArmy)army.get()));
/* 101 */             if ((S.get()).developer) {
/* 102 */               text.s();
/* 103 */               GFORMAT.i(text, AD.power().get((WArmy)army.get()));
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {}
/* 112 */         }).hh((SPRITE)(SPRITES.icons()).s.fist));
/*     */     
/* 114 */     ss.addRightC(80, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 118 */             double needed = 0.0D;
/* 119 */             double total = 0.0D;
/* 120 */             for (ADSupply s : (AD.supplies()).all) {
/* 121 */               needed += s.current().get((WArmy)army.get());
/* 122 */               total += s.targetAmount((WArmy)army.get());
/*     */             } 
/* 124 */             if (total == 0.0D) {
/* 125 */               needed = 1.0D;
/*     */             } else {
/* 127 */               needed /= total;
/* 128 */             }  GFORMAT.perc(text, needed);
/*     */           }
/* 130 */         }).hh((SPRITE)(SPRITES.icons()).s.storage).hoverTitleSet(Dic.¤¤Supplies).hoverInfoSet(Dic.¤¤SuppliesD));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 135 */     ss.body().incrW(64.0D);
/*     */     
/* 137 */     return ss;
/*     */   }
/*     */   
/*     */   public static GuiSection supplies(final GETTER<WArmy> army) {
/* 141 */     GuiSection s = new GuiSection();
/*     */     
/* 143 */     int i = 0;
/*     */     
/* 145 */     for (ADSupply su : (AD.supplies()).all) {
/* 146 */       RENDEROBJ g = supply(army, su);
/*     */       
/* 148 */       s.add(g, i % 4 * (g.body().width() + 16), i / 4 * (g.body().height() + 4));
/* 149 */       i++;
/*     */     } 
/*     */     
/* 152 */     RECTANGLE ee = s.getLast();
/*     */     
/* 154 */     s.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 158 */             GFORMAT.i(text, AD.supplies().credits().get(army.get()));
/*     */           }
/* 162 */         }).hh((SPRITES.icons()).s.money.resized(24)).hoverInfoSet(¤¤CreditsD), i % 4 * (ee.width() + 16), i / 4 * (ee.height() + 4));
/* 163 */     i++;
/*     */     
/* 165 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   private static RENDEROBJ supply(final GETTER<WArmy> army, final ADSupply su) {
/* 170 */     int w = 60;
/* 171 */     int h = 14;
/*     */     
/* 173 */     SPRITE.Imp imp = new SPRITE.Imp(w, h)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 178 */           if (su.targetAmount((WArmy)army.get()) == 0) {
/* 179 */             GMeter.render(r, GMeter.C_GREEN_DARK, 0.0D, X1, X2, Y1, Y2);
/*     */             
/*     */             return;
/*     */           } 
/* 183 */           double now = su.minimumAmount((WArmy)army.get()) / su.targetAmount((WArmy)army.get());
/* 184 */           double needed = su.current().get((WArmy)army.get()) / su.targetAmount((WArmy)army.get());
/*     */           
/* 186 */           if (su.current().get((WArmy)army.get()) >= su.minimumAmount((WArmy)army.get())) {
/* 187 */             GMeter.render(r, GMeter.C_BLUE, needed, X1, X2, Y1, Y2);
/*     */           } else {
/* 189 */             GMeter.render(r, GMeter.C_REDORANGE, needed, X1, X2, Y1, Y2);
/*     */           } 
/* 191 */           X1 = (int)(X1 + 3.0D + now * (X2 - X1 - 6));
/*     */           
/* 193 */           GCOLOR.UI().border().render(r, X1 - 1, X1 + 1, Y1, Y2);
/*     */           
/* 195 */           if (!(SETT.ROOMS()).SUPPLY.has(su.res)) {
/* 196 */             (UI.icons()).s.alert.render(r, X2 - 8, Y1 - 2);
/*     */           }
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 202 */     GHeader.HeaderHorizontal headerHorizontal = new GHeader.HeaderHorizontal((SPRITE)su.res.icon(), (SPRITE)imp)
/*     */       {
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 207 */           GBox b = (GBox)text;
/* 208 */           su.hover(b, (WArmy)army.get());
/*     */         }
/*     */       };
/*     */     
/* 212 */     if ((S.get()).developer) {
/*     */       
/* 214 */       GuiSection ss = new GuiSection(su, army)
/*     */         {
/* 216 */           STRING_RECIEVER rec = new STRING_RECIEVER()
/*     */             {
/*     */               public void acceptString(CharSequence string)
/*     */               {
/*     */                 try {
/* 221 */                   double d = Double.parseDouble(String.valueOf(string));
/* 222 */                   su.current().set((WArmy)army.get(), (int)(su.targetAmount((WArmy)army.get()) * d));
/* 223 */                 } catch (Exception exception) {}
/*     */               }
/*     */             };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 233 */             (VIEW.inters()).input.requestInput(this.rec, "set");
/* 234 */             super.clickA();
/*     */           }
/*     */         };
/* 237 */       ss.add((RENDEROBJ)headerHorizontal);
/* 238 */       return (RENDEROBJ)ss;
/*     */     } 
/* 240 */     return (RENDEROBJ)headerHorizontal;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\ArmyInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */