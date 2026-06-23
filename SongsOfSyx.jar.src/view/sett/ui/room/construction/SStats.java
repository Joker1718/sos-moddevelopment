/*     */ package view.sett.ui.room.construction;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.environment.Foundation;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.room.main.furnisher.FurnisherStat;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ final class SStats {
/*  28 */   private final HOVERABLE[] statStats = new HOVERABLE[8];
/*     */   private final HOVERABLE statResourcesStructure;
/*     */   private final HOVERABLE statResourcesCave;
/*  31 */   private final HOVERABLE[] statResources = new HOVERABLE[8];
/*     */   private final HOVERABLE foundation;
/*  33 */   private final GuiSection stats = new GuiSection();
/*     */   
/*     */   private final State s;
/*  36 */   private static CharSequence ¤¤expense = "The room does not have enough support as indicated by yellow tiles. It can be built, but will require extra materials and maintenance. Shape the room thinner, or remove room tiles in the center to allow for more support and less costs.";
/*  37 */   private static CharSequence ¤¤foundation = "This is a heavy room and relies on its foundation. Poor foundation will increase building and maintenance cost slightly, while good will decrease it.";
/*  38 */   private static CharSequence ¤¤isolation = "The room will be poorly insulated, and maintenance need will be higher as a consequence. Toggle the automatic building of walls, and use as few doorways as possible to improve it.";
/*     */ 
/*     */   
/*     */   static {
/*  42 */     D.ts(SStats.class);
/*     */   }
/*     */ 
/*     */   
/*     */   SStats(final State s) {
/*  47 */     this.s = s;
/*  48 */     this.statResourcesStructure = (HOVERABLE)new HOVERABLE.HoverableAbs(60, 24) {
/*  49 */         final GStat stat = new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  53 */               int am = s.placement.placer.structure.roofs() * ((TBuilding)s.placement.placer.structure.get()).structure.resAmount;
/*  54 */               am += s.placement.placer.structure.walls() * ((TBuilding)s.placement.placer.structure.get()).structure.resAmount;
/*  55 */               GFORMAT.i(text, am);
/*     */             }
/*     */           };
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  60 */           if (((TBuilding)s.placement.placer.structure.get()).structure.resource != null) {
/*  61 */             ((TBuilding)s.placement.placer.structure.get()).structure.resource.icon().render(r, body().x1(), body().y1());
/*  62 */             this.stat.render(r, body().x1() + 24 + 2, body().y1() + (body().height() - this.stat.height()) / 2);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  70 */           if (((TBuilding)s.placement.placer.structure.get()).structure.resource != null) {
/*  71 */             text.text(((TBuilding)s.placement.placer.structure.get()).structure.resource.name);
/*  72 */             text.NL();
/*  73 */             text.text(((TBuilding)s.placement.placer.structure.get()).structure.nameCeiling);
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  78 */     this.statResourcesCave = (HOVERABLE)new HOVERABLE.HoverableAbs(60, 24) {
/*  79 */         final GStat stat = new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/*  83 */               int am = s.placement.placer.structure.mountainWalls() * (SETT.JOBS()).clearss.caveFill.resAmount();
/*  84 */               GFORMAT.i(text, am);
/*     */             }
/*     */           };
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  89 */           if (s.placement.placer.structure.mountainWalls() == 0)
/*     */             return; 
/*  91 */           RESOURCES.STONE().icon().render(r, body().x1(), body().y1());
/*  92 */           this.stat.render(r, body().x1() + 24 + 2, body().y1() + (body().height() - this.stat.height()) / 2);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/*  97 */           text.text((RESOURCES.STONE()).name);
/*  98 */           text.NL();
/*  99 */           text.text((SETT.JOBS()).clearss.caveFill.placer().name());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 104 */     for (int i = 0; i < 8; i++) {
/* 105 */       final int k = i;
/* 106 */       this.statResources[i] = (HOVERABLE)new HOVERABLE.HoverableAbs(60, 24) {
/* 107 */           final GStat stat = new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 111 */                 double am = (SETT.ROOMS()).placement.placer.resNeeded(k);
/* 112 */                 GFORMAT.i(text, (int)Math.ceil(am));
/* 113 */                 if ((SETT.ROOMS()).placement.placer.cost().total() > 0.0D) {
/* 114 */                   text.warnify();
/* 115 */                   text.add('*');
/* 116 */                 } else if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation() && s.placement.placer.isolation() < 1.0D) {
/* 117 */                   text.warnify();
/* 118 */                 } else if ((SETT.ROOMS()).placement.placer.cost().total() < 0.0D) {
/* 119 */                   text.color((GCOLOR.T()).IGREAT);
/*     */                 } 
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 126 */             if ((SETT.ROOMS()).placement.placer.resNeeded(k) <= 0)
/*     */               return; 
/* 128 */             s.b.constructor().resource(k).icon().render(r, body().x1(), body().y1());
/* 129 */             this.stat.render(r, body().x1() + 24 + 2, body().y1() + (body().height() - this.stat.height()) / 2);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 134 */             if ((SETT.ROOMS()).placement.placer.resNeeded(k) <= 0)
/*     */               return; 
/* 136 */             GBox b = (GBox)text;
/* 137 */             RESOURCE res = s.b.constructor().resource(k);
/* 138 */             b.title(res.name);
/*     */             
/* 140 */             b.add((SPRITE)b.text().lablify().add(Dic.¤¤Cost).s().add('(').add(Dic.¤¤construction).add(')'));
/* 141 */             b.tab(7);
/*     */             
/* 143 */             GText t = b.text();
/* 144 */             t.add((SETT.ROOMS()).placement.placer.resNeededNoCost(k));
/* 145 */             b.add((SPRITE)t);
/*     */             
/* 147 */             int n = (SETT.ROOMS()).placement.placer.resNeededOnlyCost(k);
/* 148 */             if (n != 0) {
/* 149 */               t = b.text();
/* 150 */               GFORMAT.iIncr(t, n);
/* 151 */               if (n > 0)
/* 152 */                 t.warnify(); 
/* 153 */               if (n < 0)
/* 154 */                 t.color((GCOLOR.T()).IGREAT); 
/* 155 */               b.add((SPRITE)t);
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 163 */             b.NL(8);
/* 164 */             double deg = (SETT.ROOMS()).placement.placer.blueprint().degradeRate();
/* 165 */             if (deg > 0.0D) {
/* 166 */               b.add((SPRITE)b.text().lablify().add(Dic.¤¤Maintenance).s().add('(').add(DicTime.¤¤Year).add(')'));
/* 167 */               b.tab(7);
/* 168 */               deg *= 1.0D + (SETT.ROOMS()).placement.placer.cost().total();
/* 169 */               double iso = s.placement.placer.isolation();
/* 170 */               if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation()) {
/* 171 */                 deg *= 1.0D + (1.0D - s.placement.placer.isolation()) * 2.0D;
/*     */               } else {
/* 173 */                 iso = 1.0D;
/*     */               } 
/* 175 */               double none = ROOM_DEGRADER.rateResource(SETT.MAINTENANCE().speed(), (SETT.ROOMS()).placement.placer.blueprint().degradeRate(), iso, (SETT.ROOMS()).placement.placer.resNeededNoCost(k));
/* 176 */               double am = ROOM_DEGRADER.rateResource(SETT.MAINTENANCE().speed(), (SETT.ROOMS()).placement.placer.blueprint().degradeRate(), iso, (SETT.ROOMS()).placement.placer.resNeeded(k)) - none;
/* 177 */               none *= TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 178 */               am *= TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */               
/* 180 */               GText gText = b.text();
/* 181 */               gText.add(none, 2);
/* 182 */               b.add((SPRITE)gText);
/*     */               
/* 184 */               if (am != 0.0D) {
/* 185 */                 gText = b.text();
/* 186 */                 GFORMAT.f0(gText, am);
/* 187 */                 if (am > 0.0D) {
/* 188 */                   gText.warnify();
/*     */                 } else {
/* 190 */                   gText.color((GCOLOR.T()).IGREAT);
/* 191 */                 }  b.add((SPRITE)gText);
/*     */               } 
/*     */ 
/*     */               
/* 195 */               b.NL();
/*     */             } 
/*     */             
/* 198 */             b.sep();
/*     */             
/* 200 */             b.textLL(Dic.¤¤SupportRoom);
/* 201 */             b.tab(7);
/* 202 */             b.add((SPRITE)GFORMAT.perc(b.text(), 1.0D - (SETT.ROOMS()).placement.placer.cost().support()));
/* 203 */             b.NL();
/* 204 */             if ((SETT.ROOMS()).placement.placer.cost().support() > 0.0D) {
/* 205 */               b.add((SPRITE)b.text().warnify().add(SStats.¤¤expense));
/* 206 */               b.NL();
/*     */             } 
/*     */             
/* 209 */             b.NL(8);
/*     */             
/* 211 */             if ((SETT.ROOMS()).placement.placer.blueprint().constructor().isHeavy()) {
/* 212 */               b.textLL(Foundation.¤¤name);
/* 213 */               b.tab(7);
/* 214 */               double d = (SETT.ROOMS()).placement.placer.cost().foundation();
/* 215 */               b.add((SPRITE)GFORMAT.percInc(b.text(), -d, 2));
/* 216 */               b.NL();
/* 217 */               if (d >= 1.0D) {
/* 218 */                 b.add((SPRITE)b.text().normalify2().add(SStats.¤¤foundation));
/* 219 */                 b.NL();
/*     */               } else {
/*     */                 
/* 222 */                 b.add((SPRITE)b.text().warnify().add(SStats.¤¤foundation));
/* 223 */                 b.NL();
/*     */               } 
/* 225 */               b.NL(8);
/*     */             } 
/*     */ 
/*     */             
/* 229 */             if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation()) {
/* 230 */               b.textLL((SETT.ROOMS()).isolation.info.name);
/* 231 */               b.tab(7);
/* 232 */               b.add((SPRITE)GFORMAT.perc(b.text(), s.placement.placer.isolation()));
/* 233 */               b.NL();
/* 234 */               if (s.placement.placer.isolation() < 1.0D) {
/* 235 */                 b.add((SPRITE)b.text().warnify().add(SStats.¤¤isolation));
/* 236 */                 b.NL();
/*     */               } 
/*     */             } 
/*     */             
/* 240 */             b.NL(8);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 245 */       this.statStats[i] = (HOVERABLE)new HOVERABLE.HoverableAbs(250, 16) {
/* 246 */           final GStat stat = new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 249 */                 ((FurnisherStat)s.b.constructor().stats().get(k)).format(text, s.placement.placer.itemStats(k));
/*     */               }
/*     */             };
/* 252 */           final GStat title = new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 255 */                 text.lablify().add(((FurnisherStat)s.b.constructor().stats().get(k)).name());
/*     */               }
/*     */             };
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 261 */             this.stat.render(r, body().x1() + 190, body().y1());
/* 262 */             this.title.render(r, body().x1(), body().y1());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 268 */             text.text(((FurnisherStat)s.b.constructor().stats().get(k)).desc());
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/* 274 */     GuiSection f = new GuiSection();
/* 275 */     f.add((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).s.eye)
/*     */         {
/*     */           protected void renAction()
/*     */           {
/* 279 */             selectedSet((SETT.ROOMS()).placement.placer.showFoundation.is());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 284 */             (SETT.ROOMS()).placement.placer.showFoundation.toggle();
/*     */           }
/*     */         });
/*     */     
/* 288 */     f.addRightC(6, (SPRITE)(new GText((UI.FONT()).S, (SETT.OVERLAY()).FOUNDATION.name)).lablify());
/*     */     
/* 290 */     f.addRightCAbs(158, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 294 */             GFORMAT.percInc(text, -(SETT.ROOMS()).placement.placer.cost().foundation(), 2);
/*     */           }
/*     */         });
/* 297 */     f.hoverInfoSet(¤¤foundation);
/* 298 */     this.foundation = (HOVERABLE)f;
/*     */   }
/*     */ 
/*     */   
/*     */   GuiSection get() {
/* 303 */     this.stats.clear();
/* 304 */     int k = 0;
/*     */     
/* 306 */     for (int i = 0; i < this.s.b.constructor().stats().size(); i++) {
/* 307 */       this.stats.addDown(0, (RENDEROBJ)this.statStats[i]);
/*     */     }
/*     */     
/* 310 */     if (this.s.b.constructor().isHeavy()) {
/* 311 */       this.stats.addDown(0, (RENDEROBJ)this.foundation);
/*     */     }
/*     */     
/* 314 */     int w = this.statResources[0].body().width();
/* 315 */     int h = this.statResources[0].body().height();
/* 316 */     int y1 = 102;
/*     */     
/* 318 */     for (int j = 0; j < this.s.b.constructor().resources(); j++) {
/* 319 */       this.stats.add((RENDEROBJ)this.statResources[j], k % 3 * w, y1 + k / 3 * h);
/* 320 */       k++;
/*     */     } 
/* 322 */     if (this.s.b.constructor().mustBeIndoors()) {
/* 323 */       k++;
/* 324 */       this.stats.add((RENDEROBJ)this.statResourcesStructure, k % 3 * w, y1 + k / 3 * h);
/* 325 */       k++;
/* 326 */       this.stats.add((RENDEROBJ)this.statResourcesCave, k % 3 * w, y1 + k / 3 * h);
/*     */     } 
/* 328 */     this.stats.body().incrH(16.0D);
/* 329 */     return this.stats;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SStats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */