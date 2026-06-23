/*     */ package view.sett.ui.subject;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.ai.types.parent.AIModule_Parent;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.util.UIValues;
/*     */ 
/*     */ final class UISubjectActions extends GuiSection {
/*  47 */   final GuiSection section = new GuiSection();
/*     */   
/*  49 */   private static CharSequence ¤¤rename = "¤Rename subject.";
/*  50 */   private static CharSequence ¤¤ancestors = "¤Show Family.";
/*  51 */   private static CharSequence ¤¤Elevate = "¤Elevate.";
/*  52 */   private static CharSequence ¤¤NobleOk = "Click to elevate this subject into a position of power.";
/*  53 */   private static CharSequence ¤¤NobleSure = "Are you sure you wish to elevate this subject to the rank of noble?";
/*  54 */   private static CharSequence ¤¤NobleNo = "Your status determines how many nobles you can elevate. To elevate more, you must increase your status level.";
/*  55 */   private static CharSequence ¤¤NobleAlready = "This subject is already a noble one.";
/*  56 */   private static CharSequence ¤¤workplace = "¤Go to workplace";
/*     */ 
/*     */   
/*  59 */   private static CharSequence ¤¤ActionNotFor = "¤Action not available for:";
/*  60 */   private static CharSequence ¤¤ActionMarked = "¤The subject is marked for this action, but the action has not yet been consummated. Make sure the requirements of the action are fulfilled, and give it some time.";
/*  61 */   private static CharSequence ¤¤ActionConsumed = "¤This action has been consumed. Its effect will last for a few days while tampering off.";
/*  62 */   private static CharSequence ¤¤ActionCantBe = "¤Action can currently not be performed.";
/*     */   
/*  64 */   private static CharSequence ¤¤cancel = "Cancel manually assigned punishment, and let it be decided by your law settings.";
/*     */   
/*     */   static {
/*  67 */     D.ts(UISubjectActions.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   UISubjectActions(final AInfo a, HTYPE t) {
/*  73 */     int i = 0;
/*  74 */     int rrr = 4;
/*     */ 
/*     */     
/*  77 */     if ((t.parentClass()).player || (S.get()).developer) {
/*     */ 
/*     */ 
/*     */       
/*  81 */       addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.admin)
/*     */           {
/*  83 */             STRING_RECIEVER r = new STRING_RECIEVER()
/*     */               {
/*     */                 public void acceptString(CharSequence string)
/*     */                 {
/*  87 */                   if (string != null && string.length() > 0) {
/*  88 */                     STATS.APPEARANCE().setCustomName(a.a.indu(), String.valueOf(string));
/*     */                   }
/*     */                 }
/*     */               };
/*     */             
/*     */             protected void clickA() {
/*  94 */               (VIEW.inters()).input.requestInput(this.r, UISubjectActions.¤¤rename, STATS.APPEARANCE().name(a.a.indu()));
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/*  99 */               text.text(UISubjectActions.¤¤rename);
/* 100 */               super.hoverInfoGet(text);
/*     */             }
/* 103 */           }).setDim(40, 40), i++, 4, 2, 2);
/*     */       
/* 105 */       addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.familyTree)
/*     */           {
/*     */             
/*     */             protected void clickA()
/*     */             {
/* 110 */               (VIEW.UI()).family.show(a.a.indu());
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 115 */               text.text(UISubjectActions.¤¤ancestors);
/* 116 */               super.hoverInfoGet(text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 121 */               activeSet((STATS.REL().reference(a.a.indu()) > 0));
/*     */             }
/* 124 */           }).setDim(40, 40), i++, 4, 2, 2);
/*     */       
/* 126 */       if (t.CLASS == HCLASSES.CITIZEN()) {
/* 127 */         addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.noble)
/*     */             {
/* 129 */               ACTION yes = new ACTION()
/*     */                 {
/*     */                   public void exe()
/*     */                   {
/* 133 */                     a.a.nobleSet();
/*     */                   }
/*     */                 };
/*     */               
/*     */               protected void renAction() {
/* 138 */                 activeSet(((a.a.race()).playable && a.a.noble() == null));
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 143 */                 if (a.a.noble() == null && (a.a.race()).playable && (
/* 144 */                   (S.get()).developer || GAME.NOBLE().active().size() < (GAME.NOBLE()).MAX.get((BOOSTABLE_O)FACTIONS.player()))) {
/* 145 */                   (VIEW.inters()).yesNo.activate(UISubjectActions.¤¤NobleSure, this.yes, null, true);
/*     */                 }
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 152 */                 text.title(UISubjectActions.¤¤Elevate);
/* 153 */                 if (a.a.noble() != null) {
/* 154 */                   text.text(UISubjectActions.¤¤NobleAlready);
/* 155 */                 } else if (GAME.NOBLE().active().size() < (GAME.NOBLE()).MAX.get((BOOSTABLE_O)FACTIONS.player())) {
/* 156 */                   text.text(UISubjectActions.¤¤NobleOk);
/*     */                 } else {
/* 158 */                   ((GBox)text).error(UISubjectActions.¤¤NobleNo);
/*     */                 }
/*     */               
/*     */               }
/* 162 */             }).setDim(40, 40), i++, 4, 2, 2);
/*     */       }
/*     */ 
/*     */       
/* 166 */       if (t.isWorks()) {
/* 167 */         addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.workshop)
/*     */             {
/*     */               protected void clickA() {
/* 170 */                 RoomInstance i = (RoomInstance)(STATS.WORK()).EMPLOYED.get(a.a.indu());
/* 171 */                 a.follow = 0;
/* 172 */                 if (i != null) {
/* 173 */                   (VIEW.s().getWindow()).centererTile.set(i.body().cX(), i.body().cY());
/*     */                 }
/*     */               }
/*     */               
/*     */               protected void renAction() {
/* 178 */                 activeSet(((STATS.WORK()).EMPLOYED.get(a.a.indu()) != null));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 183 */                 text.text(UISubjectActions.¤¤workplace);
/* 184 */                 text.NL(4);
/* 185 */                 if ((STATS.WORK()).EMPLOYED.get(a.a.indu()) != null)
/* 186 */                   text.text((CharSequence)((RoomInstance)(STATS.WORK()).EMPLOYED.get(a.a.indu())).name()); 
/* 187 */                 super.hoverInfoGet(text);
/*     */               }
/* 190 */             }).setDim(40, 40), i++, 4, 2, 2);
/*     */       }
/*     */       
/* 193 */       if (t.CLASS == HCLASSES.CITIZEN()) {
/* 194 */         addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.sword)
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 198 */                 activeSet(!(a.a.division() == null && (STATS.BATTLE()).RECRUIT.get(a.a) == null));
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 203 */                 (VIEW.s()).battle.activate();
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 208 */                 text.title(Dic.¤¤Division);
/*     */                 
/* 210 */                 if (a.a.division() != null)
/* 211 */                   text.text((CharSequence)(a.a.division()).info.name()); 
/* 212 */                 if ((STATS.BATTLE()).RECRUIT.get(a.a) != null) {
/* 213 */                   text.text((CharSequence)((Div)(STATS.BATTLE()).RECRUIT.get(a.a)).info.name());
/*     */                 } else {
/* 215 */                   text.text(Dic.¤¤None);
/*     */                 }
/*     */               
/*     */               }
/* 219 */             }).setDim(40, 40), i++, 4, 2, 2);
/*     */       }
/*     */       
/* 222 */       if (t.CLASS.player) {
/* 223 */         addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.building)
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 227 */                 HOME h = (STATS.HOME()).GETTER.get(a.a, this);
/* 228 */                 activeSet((h != null));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 233 */                 GBox b = (GBox)text;
/* 234 */                 b.title((SETT.ROOMS()).HOME.info.name);
/* 235 */                 int ri = 0;
/* 236 */                 HOME h = (STATS.HOME()).GETTER.get(a.a, this);
/* 237 */                 if (h != null) {
/* 238 */                   for (RES_AMOUNT ra : a.a.race().home().clas(a.a.indu().clas()).resources()) {
/* 239 */                     b.add((SPRITE)ra.resource().icon());
/* 240 */                     b.add((SPRITE)GFORMAT.iofkInv(b.text(), STATS.HOME().current(a.a, ri++), ra.amount()));
/* 241 */                     b.NL();
/*     */                   } 
/*     */                 }
/*     */                 
/* 245 */                 text.NL();
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 254 */                 HOME h = (STATS.HOME()).GETTER.get(a.a, this);
/* 255 */                 if (h != null) {
/* 256 */                   VIEW.s().getWindow().centerAtTile(h.serviceX(), h.serviceY());
/* 257 */                   a.follow = 0;
/*     */                 } else {
/* 259 */                   (VIEW.s()).panels.add((ISidePanel)(VIEW.s()).ui.home, true);
/*     */                 }
/*     */               
/*     */               }
/* 263 */             }).setDim(40, 40), i++, 4, 2, 2);
/*     */         
/* 265 */         for (StatsMultipliers.StatMultiplier m : STATS.MULTIPLIERS().all()) {
/* 266 */           if (m instanceof StatsMultipliers.StatMultiplierAction) {
/* 267 */             StatsMultipliers.StatMultiplierAction aa = (StatsMultipliers.StatMultiplierAction)m;
/* 268 */             if (aa.available(t)) {
/* 269 */               addGrid(mulAction(a, aa), i++, 4, 2, 2);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 277 */     addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 281 */             COORDINATE c = a.a.ai().getDestination();
/* 282 */             if (c != null) {
/* 283 */               VIEW.s().getWindow().centerAtTile(c.x(), c.y());
/* 284 */               a.follow = 0;
/* 285 */               VIEW.s().clearAllInterrupters();
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 291 */             COORDINATE c = a.a.ai().getDestination();
/* 292 */             activeSet((c != null));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 297 */             GBox box = (GBox)text;
/* 298 */             box.text(Dic.¤¤Destination);
/* 299 */             box.NL();
/* 300 */             COORDINATE c = a.a.ai().getDestination();
/* 301 */             if (c != null) {
/* 302 */               box.add((SPRITE)box.text().add('(').add(c.x()).add(':').add(c.y()).add(')'));
/*     */             }
/*     */           }
/* 305 */         }).setDim(40, 40), i++, 4, 2, 2);
/*     */     
/* 307 */     if (t == HTYPES.PRISONER()) {
/* 308 */       addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 312 */               (AIModule_Prisoner.DATA()).punishmentSet.set(a.a.ai(), null);
/* 313 */               a.a.interrupt();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 318 */               activeSet(((AIModule_Prisoner.DATA()).punishmentSet.get(a.a.ai()) != null));
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 323 */               GBox b = (GBox)text;
/* 324 */               b.text(UISubjectActions.¤¤cancel);
/*     */             }
/* 327 */           }).setDim(40, 40), i++, 4, 2, 2);
/*     */ 
/*     */       
/* 330 */       for (CRIME_PUNISHMENTS.PUNISHMENT p : CRIME_PUNISHMENTS.ALL()) {
/* 331 */         addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)p.icon)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 335 */                 if (p != AIModule_Prisoner.punishment(a.a, a.a.ai()) && p.available(AIModule_Prisoner.DATA().clas(a.a.indu()))) {
/* 336 */                   (AIModule_Prisoner.DATA()).punishmentSet.set(a.a.ai(), p);
/* 337 */                   a.a.interrupt();
/*     */                 } 
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 343 */                 selectedSet((p == AIModule_Prisoner.punishment(a.a, a.a.ai()) && p.available(AIModule_Prisoner.DATA().clas(a.a.indu()))));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 348 */                 GBox b = (GBox)text;
/* 349 */                 b.title(p.action);
/* 350 */                 b.text(p.desc);
/* 351 */                 b.NL(4);
/*     */                 
/* 353 */                 b.add((SPRITE)(BOOSTABLES.BEHAVIOUR()).HAPPI.icon);
/* 354 */                 b.textLL((BOOSTABLES.BEHAVIOUR()).HAPPI.name);
/* 355 */                 b.tab(6);
/* 356 */                 b.add((SPRITE)GFORMAT.percInc(b.text(), -p.tyranny(a.a.indu().clas(), a.a.race())));
/* 357 */                 b.NL(0);
/*     */ 
/*     */                 
/* 360 */                 b.add((SPRITE)(BOOSTABLES.BEHAVIOUR()).LOYALTY.icon);
/* 361 */                 b.textLL((BOOSTABLES.BEHAVIOUR()).LOYALTY.name);
/* 362 */                 b.tab(6);
/* 363 */                 b.add((SPRITE)GFORMAT.percInc(b.text(), p.law(a.a.indu().clas(), a.a.race())));
/* 364 */                 b.NL(0);
/*     */               }
/* 368 */             }).setDim(40, 40), i++, 4, 2, 2);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 374 */     if ((S.get()).developer) {
/*     */       
/* 376 */       addGrid((RENDEROBJ)(new GButt.ButtPanel((HTYPES.PARENT()).icon)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 380 */               if ((a.a.indu().hType()).CLASS == HCLASSES.SLAVE()) {
/* 381 */                 if (a.a.indu().hType().child() != null)
/* 382 */                 { AIModule_Parent.GrowUp(a.a);
/* 383 */                   a.a.HTypeSet(HTYPES.SLAVE(), CAUSE_LEAVES.OTHER(), null); }
/*     */                 else
/*     */                 
/* 386 */                 { a.a.HTypeSet(HTYPES.PARENT_SLAVE(), CAUSE_LEAVES.OTHER(), null); } 
/* 387 */               } else if ((a.a.indu().hType()).CLASS == HCLASSES.CITIZEN()) {
/* 388 */                 if (a.a.indu().hType().child() != null) {
/* 389 */                   AIModule_Parent.GrowUp(a.a);
/* 390 */                   a.a.HTypeSet(HTYPES.SUBJECT(), CAUSE_LEAVES.OTHER(), null);
/*     */                 } else {
/* 392 */                   a.a.HTypeSet(HTYPES.PARENT(), CAUSE_LEAVES.OTHER(), null);
/*     */                 } 
/* 394 */               }  a.a.interrupt();
/*     */             }
/* 397 */           }).setDim(40, 40).hoverInfoSet("inpregnate"), i++, 4, 2, 2);
/*     */       
/* 399 */       addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.exit)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 409 */               a.a.interrupt();
/*     */             }
/* 412 */           }).setDim(40, 40), i++, 4, 2, 2);
/*     */       
/* 414 */       addRelBody(8, DIR.S, (RENDEROBJ)UIValues.butt(GVALUES.INDU, new GETTER<Induvidual>()
/*     */             {
/*     */               public Induvidual get()
/*     */               {
/* 418 */                 return a.a.indu();
/*     */               }
/*     */             }));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RENDEROBJ mulAction(final AInfo a, final StatsMultipliers.StatMultiplierAction m) {
/* 430 */     return (RENDEROBJ)(new GButt.ButtPanel(m.icon)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 434 */           activeSet((m.available(a.a.indu()) && !m.consumeIs(a.a) && (m.markIs(a.a) || m.canBeMarked(a.a.indu()))));
/* 435 */           selectedSet(!(!m.markIs(a.a) && !m.consumeIs(a.a)));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 440 */           GBox b = (GBox)text;
/* 441 */           b.title(m.verb);
/* 442 */           b.text(m.desc);
/* 443 */           b.NL(8);
/*     */           
/* 445 */           if (!m.available(a.a.indu())) {
/* 446 */             b.add((SPRITE)b.text().errorify().add(UISubjectActions.¤¤ActionNotFor).s().add((a.a.indu().clas()).names));
/* 447 */           } else if (m.consumeIs(a.a)) {
/* 448 */             b.textL(UISubjectActions.¤¤ActionConsumed);
/* 449 */             m.boosters.hover(text, 1.0D, -1);
/*     */           }
/* 451 */           else if (m.markIs(a.a)) {
/* 452 */             b.textL(UISubjectActions.¤¤ActionMarked);
/* 453 */           } else if (!m.canBeMarked(a.a.indu())) {
/* 454 */             b.error(UISubjectActions.¤¤ActionCantBe);
/* 455 */             b.NL(4);
/* 456 */             m.info(b, 1);
/*     */           } else {
/* 458 */             m.boosters.hover(text, 1.0D, -1);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 467 */           if (activeIs()) {
/* 468 */             m.mark(a.a, !m.markIs(a.a));
/*     */           }
/*     */         }
/* 471 */       }).setDim(40, 40);
/*     */   }
/*     */ 
/*     */   
/*     */   static GuiSection top(final AInfo a) {
/* 476 */     GuiSection s = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/* 480 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(500, (UI.FONT()).H2.height())
/*     */         {
/* 482 */           final GText name = new GText((UI.FONT()).H2, 24);
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 485 */             (GCOLOR.T()).H2.bind();
/* 486 */             this.name.clear();
/* 487 */             this.name.add(STATS.APPEARANCE().name(a.a.indu()));
/* 488 */             this.name.setMaxWidth(550);
/* 489 */             this.name.setMultipleLines(false);
/* 490 */             this.name.lablify();
/* 491 */             this.name.adjustWidth();
/* 492 */             this.name.renderC(r, body().cX(), body().cY());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 498 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(400, (UI.FONT()).S.height())
/*     */         {
/* 500 */           GText text = new GText((UI.FONT()).S, 36);
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 504 */             this.text.clear();
/* 505 */             a.a.ai().getOccupation(a.a, (Str)this.text);
/* 506 */             this.text.normalify();
/* 507 */             this.text.adjustWidth();
/* 508 */             this.text.renderC(r, body().cX(), body().cY());
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 514 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectActions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */