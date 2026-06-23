/*     */ package view.sett.ui.army;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerArmy;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.ui.div.UIDivCardWorld;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ final class Actions extends GuiSection {
/*  34 */   private static CharSequence ¤¤NoValid = "¤The selected division are already attached to a world army. You must recall them first.";
/*  35 */   private static CharSequence ¤¤Recall = "¤Recall";
/*  36 */   private static CharSequence ¤¤RecallD = "¤Recall these divisions from its world armies and have them return to the city. It will take a few days.";
/*  37 */   private static CharSequence ¤¤RecallProblem = "¤No divisions are selected that are currently attached to a world army.";
/*  38 */   private static CharSequence ¤¤SendOut = "¤Send Out";
/*  39 */   private static CharSequence ¤¤SendOutD = "¤Send this division to join an army on the world map. These soldiers will then have to be supplied through your army depots.";
/*  40 */   private static CharSequence ¤¤NotTrained = "¤Some of the soldiers are not fully trained to specification yet, and will continue to train before they join an army.";
/*  41 */   private static CharSequence ¤¤NoArmies = "¤There are no armies to send this division to. Recruit one on the world map.";
/*  42 */   private static CharSequence ¤¤NoDivs = "No divisions are selected.";
/*  43 */   private static CharSequence ¤¤DisbandD = "Are you sure you wish to disband {0} divisions?";
/*  44 */   private static CharSequence ¤¤Closed = "Our city is closed, we can not leave.";
/*  45 */   private static CharSequence ¤¤Transfer = "Soldiers of this division is still on route back to our city. We must wait until they return";
/*     */   
/*     */   static {
/*  48 */     D.ts(Actions.class);
/*     */   }
/*     */ 
/*     */   
/*     */   Actions(final ArrayList<Div> list) {
/*  53 */     int width = 170;
/*  54 */     int height = 32;
/*     */ 
/*     */     
/*  57 */     GuiSection f = new GuiSection();
/*     */     
/*  59 */     f.addRightC(0, (RENDEROBJ)new GButt.Glow((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */         {
/*     */           protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  68 */             Str tmp = Str.TMP.clear().add(Dic.¤¤Unitinfo);
/*  69 */             tmp.insert(0, (KEYS.MAIN()).UNDO.repr());
/*  70 */             tmp.insert(1, (KEYS.MAIN()).MOD.repr());
/*  71 */             text.text((CharSequence)tmp);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  77 */     GButt.ButtPanel c = new GButt.ButtPanel(Dic.¤¤Create)
/*     */       {
/*     */         
/*     */         protected void clickA()
/*     */         {
/*  82 */           Div n = GAME.ARMIES().player().getNextEmptyOrdered();
/*  83 */           if (n == null)
/*     */             return; 
/*  85 */           n.info.raceSet(FACTIONS.player().race());
/*  86 */           n.info.menSet(50);
/*  87 */           for (EquipBattle e : STATS.EQUIP().BATTLE_ALL())
/*  88 */             e.targetSet(n, 0); 
/*  89 */           for (StatsBattle.StatTraining e : (STATS.BATTLE()).TRAINING_ALL)
/*  90 */             n.info.trainingSet(e, 0.0D); 
/*  91 */           Actions.this.clicked = null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  96 */           activeSet(false);
/*  97 */           for (Div d : GAME.ARMIES().player().divisions()) {
/*  98 */             if (d.info.men() == 0) {
/*  99 */               activeSet(true);
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 107 */     c.icon((SPRITE)(UI.icons()).m.plus);
/* 108 */     c.setDim(width, height);
/* 109 */     f.addRightC(0, (RENDEROBJ)c);
/*     */     
/* 111 */     c = new GButt.ButtPanel(Dic.¤¤Edit)
/*     */       {
/* 113 */         private final Edit edit = new Edit();
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 117 */           for (int di = 0; di < list.size(); di++) {
/* 118 */             if (AD.cityDivs().attachedArmy((Div)list.get(di)) != null) {
/* 119 */               list.remove(di);
/* 120 */               di--;
/*     */             } 
/*     */           } 
/* 123 */           if (list.size() > 0) {
/* 124 */             (VIEW.inters()).popup.show((RENDEROBJ)this.edit.get((LIST<Div>)list, (CLICKABLE)this), (CLICKABLE)this);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */           isActive = false;
/* 131 */           for (Div d : list) {
/* 132 */             if (AD.cityDivs().attachedArmy(d) == null)
/* 133 */               isActive = true; 
/*     */           } 
/* 135 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*     */     
/* 139 */     c.icon((SPRITE)(UI.icons()).m.menu);
/* 140 */     c.setDim(width, height);
/* 141 */     f.addRightC(0, (RENDEROBJ)c);
/*     */ 
/*     */     
/* 144 */     c = new GButt.ButtPanel(¤¤SendOut)
/*     */       {
/* 146 */         UIPickerArmy p = new UIPickerArmy((GETTER)new GETTER.GETTER_IMP(FACTIONS.player()), 400)
/*     */           {
/*     */             protected void pick(WArmy a)
/*     */             {
/* 150 */               for (Div div : list) {
/* 151 */                 if (a.divs().canAdd() && AD.cityDivs().attachedArmy(div) == null && UIDivCardWorld.supplyError((DIV_SIMPLE)div) == null) {
/* 152 */                   AD.cityDivs().attach(a, div);
/*     */                 }
/*     */               } 
/* 155 */               (VIEW.inters()).popup.close();
/*     */             }
/*     */ 
/*     */             
/*     */             protected boolean canBePicked(WArmy a) {
/* 160 */               if (a == null)
/* 161 */                 return false; 
/* 162 */               return a.divs().canAdd();
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 168 */           if (Actions.sendProblem((LIST<Div>)list) != null) {
/*     */             return;
/*     */           }
/* 171 */           (VIEW.inters()).popup.show((RENDEROBJ)this.p, (CLICKABLE)this);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 177 */           isActive = (Actions.sendProblem((LIST<Div>)list) == null);
/* 178 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 188 */           GBox b = (GBox)text;
/*     */           
/* 190 */           b.title(Actions.¤¤SendOut);
/* 191 */           b.text(Actions.¤¤SendOutD);
/*     */           
/* 193 */           b.NL(8);
/*     */           
/* 195 */           Actions.hoverSendOutProblem((LIST<Div>)list, (GUI_BOX)b);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 201 */     c.icon((SPRITE)(UI.icons()).m.arrow_left);
/* 202 */     c.setDim(width, height);
/* 203 */     addRightC(0, (RENDEROBJ)c);
/*     */     
/* 205 */     c = new GButt.ButtPanel((SPRITE)(UI.icons()).m.fast_forw)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 209 */           (SETT.BATTLE()).info.sendOutWithoutTraining(!(SETT.BATTLE()).info.sendOutWithoutTraining());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 214 */           selectedSet((SETT.BATTLE()).info.sendOutWithoutTraining());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     c.hoverInfoSet(Dic.¤¤SendOutArmyToggleD);
/* 222 */     c.setDim(height, height);
/* 223 */     addRightC(0, (RENDEROBJ)c);
/*     */ 
/*     */     
/* 226 */     c = new GButt.ButtPanel(¤¤Recall)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 230 */           if (hardProblem((LIST<Div>)list) != null)
/*     */             return; 
/* 232 */           for (Div div : list) {
/* 233 */             if (AD.cityDivs().attachedArmy(div) != null) {
/* 234 */               AD.cityDivs().attach(null, div);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 241 */           isActive = can();
/* 242 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 247 */           GBox b = (GBox)text;
/*     */           
/* 249 */           b.title(Actions.¤¤Recall);
/* 250 */           b.text(Actions.¤¤RecallD);
/* 251 */           b.NL(8);
/*     */           
/* 253 */           if (!can()) {
/* 254 */             b.error(Actions.¤¤RecallProblem);
/*     */           }
/*     */         }
/*     */         
/*     */         private boolean can() {
/* 259 */           if (list.size() == 0)
/* 260 */             return false; 
/* 261 */           for (Div div : list) {
/* 262 */             if (AD.cityDivs().attachedArmy(div) != null) {
/* 263 */               return true;
/*     */             }
/*     */           } 
/* 266 */           return false;
/*     */         }
/*     */         
/*     */         public CharSequence hardProblem(LIST<Div> divs) {
/* 270 */           if (divs.size() == 0)
/* 271 */             return Actions.¤¤NoDivs; 
/* 272 */           if (AD.army((Faction)FACTIONS.player()).all().size() <= 0)
/* 273 */             return Actions.¤¤NoArmies; 
/* 274 */           for (Div div : divs) {
/* 275 */             if (AD.cityDivs().attachedArmy(div) != null)
/* 276 */               return null; 
/*     */           } 
/* 278 */           return Actions.¤¤NoValid;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 283 */     c.icon((SPRITE)(UI.icons()).m.arrow_right);
/* 284 */     c.setDim(width, height);
/* 285 */     addRightC(0, (RENDEROBJ)c);
/*     */     
/* 287 */     c = new GButt.ButtPanel((SPRITE)(UI.icons()).m.b_guard)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 291 */           boolean b = !is();
/* 292 */           for (Div div : list) {
/* 293 */             (SETT.ROOMS()).GUARD.activeDuty.set(div, b);
/*     */           }
/*     */         }
/*     */         
/*     */         private boolean is() {
/* 298 */           boolean s = false;
/* 299 */           for (Div div : list) {
/* 300 */             if ((SETT.ROOMS()).GUARD.activeDuty.is(div)) {
/* 301 */               s = true;
/*     */             }
/*     */           } 
/* 304 */           return s;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 310 */           isSelected = is();
/* 311 */           isActive = (list.size() > 0);
/* 312 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 317 */           GBox b = (GBox)text;
/*     */           
/* 319 */           b.title(((SETT.ROOMS()).GUARD.activeDuty.info()).name);
/* 320 */           b.text(((SETT.ROOMS()).GUARD.activeDuty.info()).desc);
/* 321 */           b.NL(8);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 327 */     c.body.setHeight(height);
/* 328 */     addRightC(0, (RENDEROBJ)c);
/*     */ 
/*     */     
/* 331 */     c = new GButt.ButtPanel(Dic.¤¤Disband)
/*     */       {
/* 333 */         final ACTION a = new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 337 */               for (Div div : list) {
/* 338 */                 if (AD.cityDivs().attachedArmy(div) == null) {
/* 339 */                   div.info.menSet(0);
/*     */                 }
/*     */               } 
/*     */             }
/*     */           };
/*     */         
/*     */         protected void clickA() {
/* 346 */           (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP.clear().add(Actions.¤¤DisbandD).insert(0, list.size()), this.a, ACTION.NOP, true);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 352 */           isActive = false;
/* 353 */           for (Div div : list) {
/* 354 */             if (AD.cityDivs().attachedArmy(div) == null)
/* 355 */               isActive = true; 
/*     */           } 
/* 357 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/*     */     
/* 361 */     c.icon((SPRITE)(UI.icons()).m.cancel);
/* 362 */     c.setDim(width, height);
/* 363 */     addRightC(0, (RENDEROBJ)c);
/*     */     
/* 365 */     addRelBody(0, DIR.N, (RENDEROBJ)f);
/*     */   }
/*     */ 
/*     */   
/*     */   static CharSequence sendProblem(LIST<Div> divs) {
/* 370 */     if (divs.size() == 0)
/* 371 */       return ¤¤NoDivs; 
/* 372 */     if (SETT.ENTRY().isClosed()) {
/* 373 */       return ¤¤Closed;
/*     */     }
/* 375 */     if (AD.army((Faction)FACTIONS.player()).all().size() <= 0)
/* 376 */       return ¤¤NoArmies; 
/* 377 */     for (Div div : divs) {
/* 378 */       if (AD.cityDivs().attachedArmy(div) == null && UIDivCardWorld.supplyError((DIV_SIMPLE)div) == null) {
/* 379 */         if (AD.cityDivs().get(div).men() > 0)
/* 380 */           return ¤¤Transfer; 
/* 381 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 385 */     for (Div div : divs) {
/* 386 */       if (UIDivCardWorld.supplyError((DIV_SIMPLE)div) != null)
/* 387 */         return UIDivCardWorld.supplyError((DIV_SIMPLE)div); 
/*     */     } 
/* 389 */     return ¤¤NoValid;
/*     */   }
/*     */ 
/*     */   
/*     */   static void hoverSendOutProblem(LIST<Div> divs, GUI_BOX box) {
/* 394 */     GBox b = (GBox)box;
/* 395 */     CharSequence h = sendProblem(divs);
/* 396 */     if (h != null) {
/* 397 */       b.error(h);
/* 398 */       b.NL(4);
/*     */     } 
/*     */     
/* 401 */     if (!(SETT.BATTLE()).info.sendOutWithoutTraining())
/*     */     {
/* 403 */       for (Div div : divs) {
/* 404 */         if ((VIEW.UI()).div.settCivic.needsTraining(div) > 0) {
/* 405 */           b.add((SPRITE)b.text().warnify().add(¤¤NotTrained));
/* 406 */           b.NL(4);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/* 412 */     UIDivCardWorld.hoverSendOut(divs, box);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */