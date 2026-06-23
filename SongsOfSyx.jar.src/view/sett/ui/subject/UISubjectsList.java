/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import java.util.Comparator;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ 
/*     */ final class UISubjectsList
/*     */   extends ISidePanel {
/*  55 */   private static CharSequence ¤¤clear = "Clear Filters";
/*  56 */   private static CharSequence ¤¤all = "Set All";
/*  57 */   private static CharSequence ¤¤favo = "Favourites";
/*  58 */   private static CharSequence ¤¤emp = "Employees";
/*  59 */   private static CharSequence ¤¤nameF = "First Name";
/*  60 */   private static CharSequence ¤¤nameL = "Surname";
/*  61 */   private static CharSequence ¤¤incoming = "Incoming";
/*     */   
/*     */   static {
/*  64 */     D.ts(UISubjectsList.class);
/*     */   }
/*     */   
/*  67 */   private int selected = -1;
/*     */   
/*     */   private Object current;
/*     */   private final ISidePanel work;
/*     */   private final Li li;
/*     */   
/*     */   public UISubjectsList() {
/*  74 */     titleSet(Dic.¤¤Subjects);
/*  75 */     this.section = new GuiSection()
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/*  80 */           UISubjectsList.this.li.sort();
/*  81 */           if (UISubjectsList.this.current != null && UISubjectsList.this.current instanceof Humanoid) {
/*  82 */             Humanoid a = (Humanoid)UISubjectsList.this.current;
/*  83 */             (VIEW.s().getWindow()).centerer.set(a.body().cX(), a.body().cY());
/*  84 */             SETT.OVERLAY().add((ENTITY)a);
/*     */           } 
/*  86 */           super.render(r, ds);
/*  87 */           if (UISubjectsList.this.selected != -1) {
/*  88 */             UISubjectsList.this.current = UISubjectsList.this.li.li.get(UISubjectsList.this.selected);
/*     */           } else {
/*  90 */             UISubjectsList.this.current = null;
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  95 */     this.li = new Li();
/*  96 */     this.section.addDownC(0, (RENDEROBJ)new Filter(this.li));
/*  97 */     this.section.addDownC(8, (RENDEROBJ)new Sorts(this.li));
/*     */     
/*  99 */     this.section.addRelBody(4, DIR.S, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 103 */             GFORMAT.iofkInv(text, UISubjectsList.this.li.li.size(), POP.physical(null, null));
/*     */           }
/*     */         });
/* 106 */     GuiSection n = makeList().createHeight(HEIGHT - 8 - this.section.body().y2(), true);
/*     */     
/* 108 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)n);
/*     */     
/* 110 */     this.work = new ISidePanel();
/* 111 */     this.work.titleSet(¤¤emp);
/* 112 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 116 */           UISubjectsList.this.li.sort();
/* 117 */           if (UISubjectsList.this.current != null && UISubjectsList.this.current instanceof Humanoid) {
/* 118 */             Humanoid a = (Humanoid)UISubjectsList.this.current;
/* 119 */             (VIEW.s().getWindow()).centerer.set(a.body().cX(), a.body().cY());
/* 120 */             SETT.OVERLAY().add((ENTITY)a);
/*     */           } 
/* 122 */           super.render(r, ds);
/* 123 */           if (UISubjectsList.this.selected != -1) {
/* 124 */             UISubjectsList.this.current = UISubjectsList.this.li.li.get(UISubjectsList.this.selected);
/*     */           } else {
/* 126 */             UISubjectsList.this.current = null;
/*     */           } 
/*     */         }
/*     */       };
/* 130 */     n = makeList().createHeight(HEIGHT - 8, true);
/* 131 */     s.add((RENDEROBJ)n);
/* 132 */     this.work.section().add((RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void show() {
/* 140 */     this.li.fWork = null;
/* 141 */     this.li.sort();
/* 142 */     (VIEW.s()).panels.add(this, true);
/*     */   }
/*     */   
/*     */   public void show(Humanoid h) {
/* 146 */     this.li.fWork = null;
/* 147 */     this.selected = -1;
/* 148 */     this.current = h;
/* 149 */     this.li.sort();
/*     */   }
/*     */   
/*     */   public void showProfession(RoomInstance work) {
/* 153 */     this.selected = -1;
/* 154 */     this.li.fWork = work;
/* 155 */     this.li.sort();
/* 156 */     (VIEW.s()).panels.add(this.work, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private GTableBuilder makeList() {
/* 161 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries() {
/* 164 */           return UISubjectsList.this.li.li.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public void click(int index) {
/* 169 */           UISubjectsList.this.selected = index;
/* 170 */           UISubjectsList.this.current = UISubjectsList.this.li.li.get(UISubjectsList.this.selected);
/* 171 */           if (UISubjectsList.this.current instanceof Humanoid && ((Humanoid)UISubjectsList.this.current).canBeClicked()) {
/* 172 */             (VIEW.s()).ui.subjects.show((Humanoid)UISubjectsList.this.current);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void doubleClick(int index) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void hover(int index) {
/* 183 */           if (index >= 0) {
/* 184 */             UISubjectsList.this.current = UISubjectsList.this.li.li.get(index);
/* 185 */             if (UISubjectsList.this.current instanceof Humanoid) {
/* 186 */               ((Humanoid)UISubjectsList.this.current).hover(VIEW.hoverBox());
/*     */             } else {
/* 188 */               (VIEW.s()).ui.subjects.hoverInfoSoldier((Induvidual)UISubjectsList.this.current, VIEW.hoverBox());
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/*     */         public boolean selectedIs(int index) {
/* 194 */           return ((VIEW.s()).ui.subjects.current() == UISubjectsList.this.li.li.get(index));
/*     */         }
/*     */       };
/*     */     
/* 198 */     builder.column(null, 32, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier) {
/* 201 */             return (RENDEROBJ)new RENDEROBJ.RenderImp(48, 24)
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, float ds)
/*     */                 {
/* 205 */                   Object o = (UISubjectsList.null.access$0(UISubjectsList.null.this)).li.li.get(((Integer)ier.get()).intValue());
/*     */                   
/* 207 */                   if (o != null) {
/* 208 */                     Induvidual a = (o instanceof Humanoid) ? ((Humanoid)o).indu() : (Induvidual)o;
/* 209 */                     (a.race().appearance()).icon.renderCY(r, 4, body().cY());
/* 210 */                     a.clas().icon().renderCY(r, 22, body().cY());
/*     */                   } 
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 218 */     final int ww = this.section.body().width();
/*     */     
/* 220 */     builder.column(null, ww, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier) {
/* 223 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text) {
/* 226 */                   Object o = (UISubjectsList.null.access$0(UISubjectsList.null.this)).li.li.get(((Integer)ier.get()).intValue());
/* 227 */                   if (o != null) {
/* 228 */                     Induvidual a = (o instanceof Humanoid) ? ((Humanoid)o).indu() : (Induvidual)o;
/* 229 */                     (UISubjectsList.null.access$0(UISubjectsList.null.this)).li.sort.format(a, text);
/* 230 */                     text.setMaxWidth(ww - 8);
/* 231 */                     text.setMultipleLines(false);
/*     */                   } 
/*     */                 }
/* 234 */               }).decrease().r();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 240 */     return builder;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Li
/*     */   {
/* 246 */     private final Bitmap1D race = new Bitmap1D(RACES.all().size(), false);
/* 247 */     private Bitmap1D type = new Bitmap1D(HTYPES.ALL().size(), false);
/*     */     private boolean favorite = false;
/*     */     private boolean soldier = false;
/*     */     private UISubjectsList.SSort sort;
/* 251 */     private RoomInstance fWork = null;
/*     */     private UISubjectsList.SSort wSort;
/* 253 */     private int favos = 0;
/* 254 */     private int sols = 0;
/* 255 */     private final ArrayList<Object> li = GUTIL.hList();
/*     */ 
/*     */     
/*     */     private final Comparator<Object> sorter;
/*     */ 
/*     */ 
/*     */     
/*     */     Li() {
/* 263 */       this.sorter = new Comparator()
/*     */         {
/*     */           
/*     */           public int compare(Object o1, Object o2)
/*     */           {
/* 268 */             Induvidual i1 = (o1 instanceof Humanoid) ? ((Humanoid)o1).indu() : (Induvidual)o1;
/* 269 */             Induvidual i2 = (o2 instanceof Humanoid) ? ((Humanoid)o2).indu() : (Induvidual)o2;
/* 270 */             double a = UISubjectsList.Li.this.sort.vale(i1, i2);
/* 271 */             if (a == 0.0D)
/* 272 */               return 0; 
/* 273 */             return (a < 0.0D) ? -1 : 1; }
/*     */         };
/*     */       this.race.setAll(true);
/*     */       this.type.setAll(true);
/*     */     } void sort() {
/* 278 */       this.favos = 0;
/* 279 */       this.sols = 0;
/* 280 */       this.li.clearSloppy();
/* 281 */       ENTITY[] es = SETT.ENTITIES().getAllEnts();
/* 282 */       int ee = SETT.ENTITIES().Imax();
/* 283 */       if (this.fWork != null) {
/* 284 */         for (int i = 0; i <= ee; i++) {
/* 285 */           ENTITY e = es[i];
/*     */           
/* 287 */           if (e instanceof Humanoid) {
/* 288 */             Humanoid h = (Humanoid)e;
/* 289 */             this.favos += (STATS.APPEARANCE()).favo.get(h.indu());
/* 290 */             if ((STATS.WORK()).EMPLOYED.get(h) == this.fWork) {
/* 291 */               this.li.add(h);
/*     */             }
/*     */           } 
/*     */         } 
/* 295 */         UISubjectsList.SSort o = this.sort;
/* 296 */         this.sort = this.wSort;
/* 297 */         this.li.sort(this.sorter);
/* 298 */         this.sort = o;
/*     */       } else {
/* 300 */         for (int i = 0; i < ee; i++) {
/* 301 */           ENTITY e = es[i];
/* 302 */           if (e instanceof Humanoid) {
/* 303 */             Humanoid h = (Humanoid)e;
/* 304 */             this.favos += (STATS.APPEARANCE()).favo.get(h.indu());
/* 305 */             if (this.race.get((h.race()).index) && this.type.get(h.indu().hType().index()) && (
/* 306 */               !this.favorite || (STATS.APPEARANCE()).favo.get(h.indu()) != 0))
/*     */             {
/* 308 */               this.li.add(h);
/*     */             }
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 314 */         for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 315 */           int m = AD.cityDivs().soldiers(di);
/* 316 */           this.sols += m;
/* 317 */           if (this.soldier) {
/* 318 */             for (int j = 0; j < m; j++) {
/* 319 */               Induvidual ii = AD.cityDivs().getSoldier(j, di);
/* 320 */               this.li.add(ii);
/* 321 */               this.favos += (STATS.APPEARANCE()).favo.get(ii);
/*     */             } 
/*     */           }
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 329 */         this.li.sort(this.sorter);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Sorts
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final CLICKABLE pop;
/*     */     
/*     */     private final UISubjectsList.Li li;
/*     */     
/*     */     private Sort current;
/*     */ 
/*     */     
/*     */     Sorts(UISubjectsList.Li li) {
/* 347 */       this.li = li;
/* 348 */       ArrayListGrower<RENDEROBJ> rows = new ArrayListGrower();
/*     */       
/* 350 */       Sort ss = new Sort(this, (SPRITE)(UI.icons()).s.admin, Dic.¤¤name)
/*     */         {
/*     */           public void format(Induvidual h, GText text)
/*     */           {
/* 354 */             text.normalify();
/* 355 */             text.add(STATS.APPEARANCE().name(h));
/*     */           }
/*     */ 
/*     */           
/*     */           public double vale(Induvidual a, Induvidual b) {
/* 360 */             Str.TMP.clear().add(STATS.APPEARANCE().name(a));
/* 361 */             return Dictionary.compare((CharSequence)Str.TMP, STATS.APPEARANCE().name(b));
/*     */           }
/*     */         };
/* 364 */       li.wSort = ss;
/*     */       
/* 366 */       rows.add(ss);
/*     */       
/* 368 */       rows.add(new Sort(this, (SPRITE)(UI.icons()).s.admin, UISubjectsList.¤¤nameF)
/*     */           {
/*     */             public void format(Induvidual h, GText text)
/*     */             {
/* 372 */               text.normalify();
/* 373 */               text.add((STATS.APPEARANCE()).nameFirst.name(h));
/*     */             }
/*     */ 
/*     */             
/*     */             public double vale(Induvidual a, Induvidual b) {
/* 378 */               Str.TMP.clear().add((STATS.APPEARANCE()).nameFirst.name(a));
/* 379 */               return Dictionary.compare((CharSequence)Str.TMP, (STATS.APPEARANCE()).nameFirst.name(b));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 384 */       rows.add(new Sort(this, (SPRITE)(UI.icons()).s.admin, UISubjectsList.¤¤nameL)
/*     */           {
/*     */             public void format(Induvidual h, GText text)
/*     */             {
/* 388 */               text.normalify();
/* 389 */               text.add((STATS.APPEARANCE()).nameLast.name(h));
/*     */             }
/*     */ 
/*     */             
/*     */             public double vale(Induvidual a, Induvidual b) {
/* 394 */               Str.TMP.clear().add((STATS.APPEARANCE()).nameLast.name(a));
/* 395 */               return Dictionary.compare((CharSequence)Str.TMP, (STATS.APPEARANCE()).nameLast.name(b));
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 400 */       rows.add(new Sort(this, (SPRITE)(UI.icons()).s.clock, Dic.¤¤Age)
/*     */           {
/*     */             public void format(Induvidual h, GText text)
/*     */             {
/* 404 */               text.normalify();
/* 405 */               text.add((STATS.POP()).age.DAYS.get(h) / TIME.years().bitConversion((TIMECYCLE)TIME.days()), 2);
/*     */             }
/*     */ 
/*     */             
/*     */             public double vale(Induvidual a, Induvidual b) {
/* 410 */               return ((STATS.POP()).age.DAYS.get(a) - (STATS.POP()).age.DAYS.get(b));
/*     */             }
/*     */           });
/*     */       
/* 414 */       rows.add(new Sort(this, (SPRITE)(UI.icons()).s.hammer, (STATS.WORK()).EMPLOYED.info.name)
/*     */           {
/*     */             public void format(Induvidual h, GText text)
/*     */             {
/* 418 */               text.normalify();
/* 419 */               RoomBlueprintImp a = (RoomBlueprintImp)(STATS.WORK()).profession.get(h);
/* 420 */               if (a == null) {
/* 421 */                 text.add(Dic.¤¤Oddjobber);
/*     */               } else {
/* 423 */                 text.add((a.employment()).title);
/*     */               } 
/*     */             }
/*     */             
/*     */             public double vale(Induvidual a, Induvidual b) {
/* 428 */               CharSequence q1 = Dic.¤¤Oddjobber;
/* 429 */               CharSequence q2 = Dic.¤¤Oddjobber;
/*     */               
/* 431 */               RoomBlueprintImp e = (RoomBlueprintImp)(STATS.WORK()).profession.get(a);
/* 432 */               if (e != null)
/* 433 */                 q1 = (e.employment()).title; 
/* 434 */               e = (RoomBlueprintImp)(STATS.WORK()).profession.get(b);
/* 435 */               if (e != null)
/* 436 */                 q2 = (e.employment()).title; 
/* 437 */               return Dictionary.compare(q1, q2);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 442 */       for (STAT s : STATS.createMatterList(true, false, null)) {
/* 443 */         if (s == (STATS.POP()).age.AGE_DAYS) {
/*     */           continue;
/*     */         }
/* 446 */         rows.add(new Sort(this, (s.info()).icon, (s.info()).name)
/*     */             {
/*     */               public void format(Induvidual h, GText text)
/*     */               {
/* 450 */                 if (s.info().isInt())
/* 451 */                 { if (s.indu().max(h) == 1) {
/* 452 */                     GFORMAT.bool(text, (s.indu().get(h) == 1));
/*     */                   } else {
/* 454 */                     GFORMAT.i(text, s.indu().get(h));
/*     */                   }  }
/* 456 */                 else { GFORMAT.perc(text, s.indu().getD(h)); }
/*     */               
/*     */               }
/*     */ 
/*     */               
/*     */               public double vale(Induvidual a, Induvidual b) {
/* 462 */                 return (s.indu().get(b) - s.indu().get(a));
/*     */               }
/*     */             });
/*     */       } 
/*     */       
/* 467 */       this.body.setHeight(((RENDEROBJ)rows.get(0)).body().height());
/* 468 */       this.body.setWidth(((RENDEROBJ)rows.get(0)).body().width());
/*     */       
/* 470 */       this.pop = (new GScrollRows((Iterable)rows, 500)).view();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 478 */       GButt.ButtPanel.renderBG(r, isActive, false, isHovered, (RECTANGLE)this.body);
/*     */       
/* 480 */       this.current.icon.renderCY(r, this.body.x1() + 4, this.body.cY());
/* 481 */       (UI.FONT()).S.renderCY(r, this.body.x1() + 32, this.body.cY(), this.current.name);
/*     */       
/* 483 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 489 */       (VIEW.inters()).popup.show((RENDEROBJ)this.pop, (CLICKABLE)this);
/*     */     }
/*     */     
/*     */     private abstract class Sort
/*     */       extends GButt.ButtPanel implements UISubjectsList.SSort {
/*     */       private final SPRITE icon;
/*     */       private final CharSequence name;
/*     */       
/*     */       public Sort(SPRITE icon, CharSequence name) {
/* 498 */         super(name); Icons.S.IconS iconS;
/* 499 */         this.name = name;
/* 500 */         if (icon == null)
/* 501 */           iconS = (UI.icons()).s.cancel; 
/* 502 */         this.icon = iconS.resized(16);
/* 503 */         icon(this.icon);
/* 504 */         this.body.setWidth(400.0D);
/*     */         
/* 506 */         if (UISubjectsList.Sorts.this.current == null) {
/* 507 */           UISubjectsList.Sorts.this.current = this;
/* 508 */           UISubjectsList.Sorts.this.li.sort = this;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       protected void clickA() {
/* 514 */         UISubjectsList.Sorts.this.current = this;
/* 515 */         UISubjectsList.Sorts.this.li.sort = this;
/* 516 */         (VIEW.inters()).popup.close();
/*     */       }
/*     */ 
/*     */       
/*     */       protected void renAction() {
/* 521 */         selectedSet((UISubjectsList.Sorts.this.current == this));
/*     */       }
/*     */     }
/*     */   }
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
/*     */   private static class Filter
/*     */     extends GuiSection
/*     */   {
/*     */     Filter(final UISubjectsList.Li li) {
/* 544 */       GRows rows = new GRows(7);
/*     */       
/* 546 */       rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).m.cancel)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 550 */               li.race.setAll(false);
/*     */             }
/* 553 */           }).hoverInfoSet(UISubjectsList.¤¤all));
/*     */       
/* 555 */       rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).m.arrow_right)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 559 */               li.race.setAll(true);
/*     */             }
/* 562 */           }).hoverInfoSet(UISubjectsList.¤¤clear));
/*     */       
/* 564 */       for (Race ra : RACES.all()) {
/*     */         
/* 566 */         rows.add((RENDEROBJ)new Butt((SPRITE)(ra.appearance()).icon)
/*     */             {
/*     */               
/*     */               protected void hov(GBox b)
/*     */               {
/* 571 */                 b.title(ra.info.names);
/* 572 */                 b.text(ra.info.desc);
/* 573 */                 b.sep();
/*     */                 
/* 575 */                 for (HTYPE t : HTYPES.ALL()) {
/* 576 */                   int p = (STATS.POP()).POP.type().get(HTYPE_RACE.get(ra, t));
/* 577 */                   if (t.visible() && p > 0) {
/* 578 */                     b.add(t.icon);
/* 579 */                     b.textLL(t.names);
/* 580 */                     b.tab(6);
/* 581 */                     b.add((SPRITE)GFORMAT.i(b.text(), p));
/* 582 */                     b.NL();
/*     */                   } 
/*     */                 } 
/*     */ 
/*     */                 
/* 587 */                 b.NL();
/*     */                 
/* 589 */                 b.add((HTYPES.SOLDIER()).icon);
/* 590 */                 b.textLL((HTYPES.SOLDIER()).names);
/* 591 */                 b.tab(6);
/* 592 */                 b.add((SPRITE)GFORMAT.i(b.text(), AD.cityDivs().total(ra)));
/*     */                 
/* 594 */                 b.NL(8);
/*     */                 
/* 596 */                 b.add((SPRITE)(UI.icons()).s.arrow_left);
/* 597 */                 b.textLL(UISubjectsList.¤¤incoming);
/* 598 */                 b.tab(6);
/* 599 */                 b.add((SPRITE)GFORMAT.i(b.text(), SETT.ENTRY().onTheirWay(ra, null)));
/*     */               }
/*     */ 
/*     */ 
/*     */               
/*     */               protected int get() {
/* 605 */                 return POP.tot(null, ra);
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 610 */                 selectedSet(li.race.get(ra.index));
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 615 */                 li.race.toggle(ra.index());
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 621 */       for (RENDEROBJ o : rows.rows()) {
/* 622 */         addDown(0, o);
/*     */       }
/* 624 */       body().incrH(8.0D);
/*     */       
/* 626 */       rows = new GRows(8);
/*     */       
/* 628 */       rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).s.cancel.createColored((GCOLOR.UI()).BAD.hovered))
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 632 */               li.type.setAll(false);
/* 633 */               li.favorite = false;
/* 634 */               li.soldier = false;
/*     */             }
/* 637 */           }).hoverInfoSet(UISubjectsList.¤¤all));
/*     */       
/* 639 */       rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).s.arrow_right.createColored((GCOLOR.UI()).GOOD.hovered))
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 643 */               li.type.setAll(true);
/* 644 */               li.favorite = false;
/* 645 */               li.soldier = false;
/*     */             }
/* 648 */           }).hoverInfoSet(UISubjectsList.¤¤clear));
/*     */       
/* 650 */       rows.add((RENDEROBJ)new Butt((SPRITE)(UI.icons()).s.heart)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 654 */               li.favorite = !li.favorite;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 659 */               selectedSet(li.favorite);
/*     */             }
/*     */ 
/*     */             
/*     */             protected int get() {
/* 664 */               return li.favos;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void hov(GBox b) {
/* 669 */               b.title(UISubjectsList.¤¤favo);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 674 */       rows.add((RENDEROBJ)new Butt((HTYPES.SOLDIER()).icon)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 678 */               li.soldier = !li.soldier;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 683 */               selectedSet(li.soldier);
/*     */             }
/*     */ 
/*     */             
/*     */             protected int get() {
/* 688 */               return li.sols;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void hov(GBox b) {
/* 693 */               b.title((HTYPES.SOLDIER()).name);
/* 694 */               b.text((HTYPES.SOLDIER()).desc);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 699 */       for (HTYPE t : HTYPES.ALL()) {
/* 700 */         if (!t.visible()) {
/*     */           continue;
/*     */         }
/* 703 */         rows.add((RENDEROBJ)new Butt(t.icon)
/*     */             {
/*     */               protected void hov(GBox b)
/*     */               {
/* 707 */                 int tab = 0;
/* 708 */                 b.title(t.names);
/* 709 */                 b.text(t.desc);
/* 710 */                 b.NL();
/* 711 */                 for (Race r : RACES.all()) {
/* 712 */                   b.tab(tab);
/*     */                   
/* 714 */                   b.add((SPRITE)(r.appearance()).icon);
/* 715 */                   b.add((SPRITE)GFORMAT.i(b.text(), STATS.POP().pop(r, t)));
/* 716 */                   b.space();
/* 717 */                   tab += 3;
/* 718 */                   if (tab > 9) {
/* 719 */                     b.NL();
/* 720 */                     tab = 0;
/*     */                   } 
/*     */                 } 
/* 723 */                 b.NL(8);
/*     */                 
/* 725 */                 b.add((SPRITE)(UI.icons()).s.arrow_left);
/* 726 */                 b.textLL(UISubjectsList.¤¤incoming);
/* 727 */                 b.tab(6);
/* 728 */                 b.add((SPRITE)GFORMAT.i(b.text(), SETT.ENTRY().onTheirWay(null, t)));
/*     */               }
/*     */ 
/*     */               
/*     */               protected int get() {
/* 733 */                 return STATS.POP().pop(t);
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 738 */                 selectedSet(li.type.get(t.index()));
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 743 */                 li.type.toggle(t.index());
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 751 */       for (RENDEROBJ o : rows.rows()) {
/* 752 */         addDown(0, o);
/*     */       }
/*     */     }
/*     */     
/*     */     private static abstract class Butt
/*     */       extends CLICKABLE.ClickableAbs
/*     */     {
/*     */       private final SPRITE icon;
/* 760 */       private final GText tt = new GText((UI.FONT()).S, 16);
/*     */ 
/*     */       
/*     */       Butt(SPRITE icon) {
/* 764 */         super(icon.height() + 56, icon.height() + 8);
/* 765 */         this.icon = icon;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 771 */         GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 772 */         this.icon.renderCY(r, this.body.x1() + 4, body().cY());
/* 773 */         GFORMAT.i(this.tt.clear(), get());
/* 774 */         this.tt.renderCY(r, body().x1() + 8 + this.icon.width(), this.body.cY());
/* 775 */         GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       }
/*     */ 
/*     */       
/*     */       protected abstract int get();
/*     */       
/*     */       public void hoverInfoGet(GUI_BOX text) {
/* 782 */         hov((GBox)text);
/*     */       }
/*     */ 
/*     */       
/*     */       protected abstract void hov(GBox param2GBox);
/*     */     }
/*     */     
/*     */     private static class ButtS
/*     */       extends CLICKABLE.ClickableAbs
/*     */     {
/*     */       private final SPRITE icon;
/*     */       
/*     */       ButtS(SPRITE icon) {
/* 795 */         super(icon.height() + 56, icon.height() + 8);
/* 796 */         this.icon = icon;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 802 */         GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 803 */         this.icon.renderC(r, this.body.cX(), body().cY());
/* 804 */         GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static interface SSort {
/*     */     double vale(Induvidual param1Induvidual1, Induvidual param1Induvidual2);
/*     */     
/*     */     void format(Induvidual param1Induvidual, GText param1GText);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectsList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */