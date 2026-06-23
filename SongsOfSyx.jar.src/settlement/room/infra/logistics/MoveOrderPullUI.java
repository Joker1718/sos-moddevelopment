/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.PlacableSingle;
/*     */ 
/*     */ public class MoveOrderPullUI
/*     */   extends GuiSection
/*     */ {
/*  53 */   private static CharSequence ¤¤name = "¤Pull Source";
/*  54 */   private static CharSequence ¤¤notSet = "not set";
/*  55 */   private static CharSequence ¤¤notSetC = "Click to set the pull source storage site.";
/*  56 */   private static CharSequence ¤¤setC = "Click to go to pull source.";
/*  57 */   private static CharSequence ¤¤issue = "Click to issue an order to pull from another storage site.";
/*  58 */   private static CharSequence ¤¤Choose = "¤Choose a storage site to pull from.";
/*  59 */   private static CharSequence ¤¤Limit = "¤Pull Limit";
/*  60 */   private static CharSequence ¤¤LimitD = "¤Only pull when the source storage exceeds this limit.";
/*  61 */   private static CharSequence ¤¤auto = "¤Set next order to closest source.";
/*  62 */   private static CharSequence ¤¤hold = "¤Hold {0} to move to source room. Click to select source room.";
/*  63 */   static CharSequence ¤¤paster = "Paste settings";
/*  64 */   static CharSequence ¤¤pasterD = "Paste current setting onto other room of the same type.";
/*     */   
/*     */   private final GETTER<? extends MoveOrderPull.MoveOrderPullInstance> source;
/*     */   
/*     */   private final GETTER<? extends RoomInstance> room;
/*     */   private int placerII;
/*     */   
/*     */   static {
/*  72 */     D.ts(MoveOrderPullUI.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPullUI(final GETTER<? extends MoveOrderPull.MoveOrderPullInstance> source, final GETTER<? extends RoomInstance> room, LIST<RESOURCE> resources, int orderAm) {
/*  77 */     this.source = source;
/*  78 */     this.room = room;
/*  79 */     final Placer placer = new Placer();
/*  80 */     final Detail popup = new Detail(placer, resources);
/*     */     
/*  82 */     GButt.ButtPanel cc = new GButt.ButtPanel((SPRITE)(UI.icons()).s.cog)
/*     */       {
/*     */         protected void clickA() {
/*  85 */           GUTIL.flooder().init(this);
/*  86 */           GUTIL.flooder().pushSloppy(((RoomInstance)room.get()).mX(), ((RoomInstance)room.get()).mY(), 0.0D);
/*  87 */           while (GUTIL.flooder().hasMore()) {
/*  88 */             PathTile t = GUTIL.flooder().pollSmallest();
/*     */             
/*  90 */             Room r = (Room)(SETT.ROOMS()).map.get((COORDINATE)t);
/*  91 */             if (r != null && r != source.get() && r.mX(t.x(), t.y()) == t.x() && r.mY(t.x(), t.y()) == t.y() && 
/*  92 */               r instanceof MoveJob.ROOM_MOVE_SOURCE) {
/*  93 */               MoveJob.ROOM_MOVE_SOURCE ss = (MoveJob.ROOM_MOVE_SOURCE)r;
/*  94 */               if (ss.moveCapacity().has(((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrderPullAccepted())) {
/*  95 */                 for (int ii = 0; ii < (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()).length; ii++) {
/*  96 */                   MoveOrderPull o = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[ii];
/*  97 */                   if (o == null || o.source() == null || o.source() == ss) {
/*  98 */                     ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[ii] = new MoveOrderPull((RoomInstance)r, ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrderPullAccepted());
/*  99 */                     (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[ii]).pullLimit = 0;
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/* 104 */                 GUTIL.flooder().done();
/*     */               } 
/*     */             } 
/*     */ 
/*     */             
/* 109 */             for (DIR d : DIR.ALL) {
/* 110 */               if (SETT.IN_BOUNDS((COORDINATE)t, d) && (SETT.PATH()).coster.player.getCost(t.x(), t.y(), t.x() + d.x(), t.y() + d.y()) > 0.0D) {
/* 111 */                 GUTIL.flooder().pushSmaller(t.x() + d.x(), t.y() + d.y(), t.getValue() + d.tileDistance());
/*     */               }
/*     */             } 
/*     */           } 
/* 115 */           GUTIL.flooder().done();
/* 116 */           super.clickA();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 121 */           activeSet(true); byte b; int i;
/*     */           MoveOrderPull[] arrayOfMoveOrderPull;
/* 123 */           for (i = (arrayOfMoveOrderPull = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()).length, b = 0; b < i; ) { MoveOrderPull o = arrayOfMoveOrderPull[b];
/* 124 */             if (o == null || o.source() == null) {
/*     */               return;
/*     */             }
/*     */             b++; }
/*     */           
/* 129 */           activeSet(false);
/*     */         }
/*     */       };
/*     */     
/* 133 */     cc.hoverInfoSet(¤¤auto);
/* 134 */     cc.body.setHeight(48.0D);
/* 135 */     addRightC(0, (RENDEROBJ)cc);
/*     */ 
/*     */     
/* 138 */     for (int i = 0; i < orderAm; i++) {
/*     */       
/* 140 */       final int oi = i;
/*     */       
/* 142 */       addRightC(0, (RENDEROBJ)new CLICKABLE.ClickableAbs(48, 48)
/*     */           {
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */             {
/* 146 */               GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 147 */               if (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi] == null) {
/* 148 */                 (UI.icons()).m.storage_pull.renderC(r, this.body.cX(), this.body.cY());
/* 149 */                 GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */                 
/*     */                 return;
/*     */               } 
/* 153 */               MoveOrderPull o = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi];
/*     */               
/* 155 */               if (o.problem((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 156 */                 (GCOLOR.UI()).BAD.hovered.bind();
/* 157 */               } else if (o.warning((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 158 */                 (GCOLOR.UI()).SOSO.hovered.bind();
/*     */               } else {
/* 160 */                 (GCOLOR.UI()).GOOD.hovered.bind();
/*     */               } 
/* 162 */               (UI.icons()).s.alert.renderC(r, body().cX(), this.body.cY());
/* 163 */               COLOR.unbind();
/* 164 */               GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */               
/* 166 */               if (isHovered && ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi].source() != null) {
/* 167 */                 RoomInstance ins = (RoomInstance)((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi].source();
/* 168 */                 SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 174 */               if (((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi] == null) {
/* 175 */                 placer.activate(oi);
/*     */               } else {
/* 177 */                 (VIEW.inters()).popup.show((RENDEROBJ)popup.get(oi), (CLICKABLE)this);
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 183 */               GBox b = (GBox)text;
/* 184 */               b.title(MoveOrderPullUI.¤¤name);
/* 185 */               MoveOrderPull o = ((MoveOrderPull.MoveOrderPullInstance)source.get()).moveOrdersPull()[oi];
/* 186 */               if (o == null) {
/* 187 */                 b.text(MoveOrderPullUI.¤¤issue);
/*     */                 return;
/*     */               } 
/* 190 */               b.textLL(MoveOrderPullUI.¤¤name);
/* 191 */               b.tab(6);
/* 192 */               if (o.sourceI() == null) {
/* 193 */                 b.error(MoveOrderPullUI.¤¤notSet);
/*     */               } else {
/* 195 */                 b.text((CharSequence)o.sourceI().name());
/*     */               } 
/* 197 */               b.NL();
/*     */               
/* 199 */               if (o.problem((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 200 */                 b.error(o.problem((MoveOrderPull.MoveOrderPullInstance)source.get()));
/* 201 */               } else if (o.warning((MoveOrderPull.MoveOrderPullInstance)source.get()) != null) {
/* 202 */                 b.add((SPRITE)b.text().warnify().add(o.warning((MoveOrderPull.MoveOrderPullInstance)source.get())));
/*     */               } 
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     cc = new GButt.ButtPanel((SPRITE)(UI.icons()).s.copy) {
/* 212 */         MoveOrderPullUI.Paster pp = new MoveOrderPullUI.Paster();
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 216 */           this.pp.current = (MoveOrderPull.MoveOrderPullInstance)source.get();
/* 217 */           (VIEW.s()).tools.place((PLACABLE)this.pp);
/* 218 */           super.clickA();
/*     */         }
/*     */       };
/* 221 */     cc.hoverInfoSet(¤¤pasterD);
/* 222 */     cc.body.setHeight(48.0D);
/* 223 */     addRightC(0, (RENDEROBJ)cc);
/*     */ 
/*     */     
/* 226 */     body().incrW(cc.body.width());
/*     */   }
/*     */   
/*     */   private class Detail
/*     */   {
/*     */     private MoveOrderPull o;
/* 232 */     private final GuiSection section = new GuiSection();
/*     */     
/*     */     private int oi;
/*     */     
/*     */     Detail(final MoveOrderPullUI.Placer placer, LIST<RESOURCE> resources) {
/* 237 */       this.section.add((RENDEROBJ)(new HOVERABLE.Sprite(placer.getIcon())).hoverInfoSet(placer.name()), 0, this.section.body().y2() + 4);
/* 238 */       this.section.addRightCAbs(48, (RENDEROBJ)new CLICKABLE.ClickableAbs(200, 32)
/*     */           {
/* 240 */             final GText t = new GText((UI.FONT()).S, 24);
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 244 */               GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 245 */               this.t.setMaxWidth(180);
/* 246 */               this.t.setMultipleLines(false);
/* 247 */               this.t.clear();
/* 248 */               this.t.normalify();
/* 249 */               if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 250 */                 this.t.add(MoveOrderPullUI.¤¤notSet);
/* 251 */                 this.t.errorify();
/*     */               } else {
/* 253 */                 this.t.add((CharSequence)MoveOrderPullUI.Detail.this.o.sourceI().name());
/*     */               } 
/* 255 */               this.t.adjustWidth();
/* 256 */               this.t.renderC(r, (RECTANGLE)this.body);
/* 257 */               GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 258 */               if ((((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()).length >= MoveOrderPullUI.Detail.this.oi)
/*     */                 return; 
/* 260 */               if (isHovered && ((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi].source() != null) {
/* 261 */                 RoomInstance ins = (RoomInstance)((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi].source();
/* 262 */                 SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 268 */               text.title(placer.name());
/* 269 */               if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 270 */                 text.text(MoveOrderPullUI.¤¤notSetC);
/*     */               } else {
/* 272 */                 text.text(MoveOrderPullUI.¤¤setC);
/*     */               } 
/* 274 */               super.hoverInfoGet(text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 279 */               if (MoveOrderPullUI.Detail.this.o.source() == null) {
/* 280 */                 placer.activate(MoveOrderPullUI.Detail.this.oi);
/*     */               } else {
/* 282 */                 (VIEW.s().getWindow()).centererTile.set(MoveOrderPullUI.Detail.this.o.sourceI().body().cX(), MoveOrderPullUI.Detail.this.o.sourceI().body().cY());
/*     */               } 
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 289 */       RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(300, 64) {
/* 290 */           GText t = new GText((UI.FONT()).S, 128);
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 294 */             this.t.clear();
/* 295 */             this.t.setMultipleLines(true);
/* 296 */             this.t.setMaxWidth(280);
/* 297 */             if (MoveOrderPullUI.Detail.this.o.problem((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()) != null) {
/* 298 */               this.t.add(MoveOrderPullUI.Detail.this.o.problem((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()));
/* 299 */               this.t.errorify();
/* 300 */             } else if (MoveOrderPullUI.Detail.this.o.warning((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()) != null) {
/* 301 */               this.t.add(MoveOrderPullUI.Detail.this.o.warning((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()));
/* 302 */               this.t.warnify();
/*     */             } 
/* 304 */             this.t.adjustWidth();
/* 305 */             this.t.render(r, this.body.x1(), this.body.y1());
/*     */           }
/*     */         };
/* 308 */       this.section.add((RENDEROBJ)renderImp, 0, this.section.body().y2() + 4);
/*     */ 
/*     */       
/* 311 */       if (resources != null) {
/* 312 */         int i = 0;
/* 313 */         int rows = 8;
/* 314 */         GuiSection s = new GuiSection();
/*     */         
/* 316 */         s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.ok)
/*     */             {
/*     */               protected void clickA() {
/* 319 */                 MoveOrderPullUI.Detail.this.o.resbits.or(RBIT.ALL);
/*     */               }
/* 322 */             }i++, rows, 0, 0);
/*     */         
/* 324 */         s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.cancel)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 328 */                 MoveOrderPullUI.Detail.this.o.resbits.clear();
/*     */               }
/* 331 */             }i++, rows, 0, 0);
/*     */         
/* 333 */         for (RESOURCE r : resources) {
/*     */           
/* 335 */           s.addGrid((RENDEROBJ)new GButt.ButtPanel((SPRITE)r.icon())
/*     */               {
/*     */                 protected void renAction()
/*     */                 {
/* 339 */                   selectedSet(MoveOrderPullUI.Detail.this.o.resbits.has(r));
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected void clickA() {
/* 344 */                   MoveOrderPullUI.Detail.this.o.resbits.toggle(r);
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 protected void render(SPRITE_RENDERER re, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 350 */                   super.render(re, ds, isActive, isSelected, isHovered);
/* 351 */                   if (MoveOrderPullUI.Detail.this.o.source() == null || !MoveOrderPullUI.Detail.this.o.source().moveCapacity().has(r.bit) || !((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrderPullAccepted().has(r.bit)) {
/* 352 */                     OPACITY.O50.bind();
/* 353 */                     COLOR.BLACK.render(re, (RECTANGLE)this.body, -4);
/* 354 */                     OPACITY.unbind();
/*     */                   }
/*     */                 
/*     */                 }
/* 358 */               }i++, rows, 0, 0);
/*     */         } 
/*     */         
/* 361 */         this.section.addRelBody(32, DIR.E, (RENDEROBJ)s);
/*     */       } 
/*     */       
/* 364 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 368 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 373 */             return 100;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 378 */             return MoveOrderPullUI.Detail.this.o.pullLimit;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 383 */             MoveOrderPullUI.Detail.this.o.pullLimit = (byte)t;
/*     */           }
/*     */         };
/*     */       
/* 387 */       GSliderInt sl = new GSliderInt(ii, 160, true)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 391 */             GBox b = (GBox)text;
/* 392 */             b.title(MoveOrderPullUI.¤¤Limit);
/* 393 */             b.text(MoveOrderPullUI.¤¤LimitD);
/*     */ 
/*     */             
/* 396 */             b.NL();
/* 397 */             b.add((SPRITE)GFORMAT.perc(b.text(), MoveOrderPullUI.Detail.this.o.pullLimit / 100.0D));
/* 398 */             b.NL();
/*     */             
/* 400 */             if (MoveOrderPullUI.Detail.this.o.source() != null) {
/* 401 */               for (RESOURCE res : RESOURCES.ALL()) {
/* 402 */                 if (MoveOrderPullUI.Detail.this.o.source().moveCapacity().has(res) && MoveOrderPullUI.Detail.this.o.resbits.has(res)) {
/* 403 */                   int am = MoveOrderPullUI.Detail.this.o.source().moveCapacityAm(res);
/* 404 */                   b.add((SPRITE)res.icon());
/* 405 */                   b.add((SPRITE)GFORMAT.i(b.text(), (long)((MoveOrderPullUI.Detail.this.o.pullLimit * am) / 100.0D)));
/* 406 */                   b.NL();
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 414 */       sl.addRelBody(8, DIR.W, (RENDEROBJ)new GHeader(MoveOrderPullUI.¤¤Limit));
/*     */       
/* 416 */       this.section.addRelBody(6, DIR.S, (RENDEROBJ)sl);
/*     */ 
/*     */       
/* 419 */       this.section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤remove)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 423 */               ((MoveOrderPull.MoveOrderPullInstance)(MoveOrderPullUI.Detail.access$0(MoveOrderPullUI.Detail.this)).source.get()).moveOrdersPull()[MoveOrderPullUI.Detail.this.oi] = null;
/* 424 */               (VIEW.inters()).popup.close();
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiSection get(int oi) {
/* 431 */       this.oi = oi;
/* 432 */       this.o = ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[oi];
/* 433 */       return this.section;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/* 438 */   private static final ArrayListResize<MoveJob.ROOM_MOVE_SOURCE> prooms = new ArrayListResize(256);
/*     */   
/*     */   private static final int placerUIrows = 4;
/*     */   
/*     */   private class PlacerUI
/*     */     extends GuiSection
/*     */   {
/*     */     PlacerUI() {
/* 446 */       GTableBuilder bu = new GTableBuilder()
/*     */         {
/*     */           public int nrOFEntries()
/*     */           {
/* 450 */             return (int)Math.ceil(MoveOrderPullUI.prooms.size() / 4.0D);
/*     */           }
/*     */         };
/*     */       
/* 454 */       bu.column(null, 400, new GTableBuilder.GRowBuilder()
/*     */           {
/*     */             public RENDEROBJ build(GETTER<Integer> ier)
/*     */             {
/* 458 */               GuiSection s = new GuiSection();
/* 459 */               for (int i = 0; i < 4; i++)
/* 460 */                 s.addRight(0, (RENDEROBJ)new MoveOrderPullUI.PlacerUIButt(ier, i)); 
/* 461 */               return (RENDEROBJ)s;
/*     */             }
/*     */           });
/*     */       
/* 465 */       add((RENDEROBJ)bu.create(4, false));
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 470 */       MoveOrderPullUI.prooms.clearSoft();
/* 471 */       for (RoomBlueprintIns<?> i : (Iterable<RoomBlueprintIns<?>>)SETT.ROOMS().ins()) {
/* 472 */         if (i.instancesSize() > 0 && i.getInstance(0) instanceof MoveJob.ROOM_MOVE_SOURCE) {
/* 473 */           for (int ii = 0; ii < i.instancesSize(); ii++) {
/* 474 */             if (i.getInstance(ii) != MoveOrderPullUI.this.room.get()) {
/* 475 */               MoveOrderPullUI.prooms.add(i.getInstance(ii));
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/* 480 */       (SETT.OVERLAY()).PULL.add((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get());
/* 481 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */   
/*     */   private class PlacerUIButt
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     private final int off;
/*     */     
/*     */     public PlacerUIButt(GETTER<Integer> ier, int off) {
/* 492 */       this.ier = ier;
/* 493 */       this.off = off;
/* 494 */       body().setWidth(100.0D).setHeight(24.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 499 */       int i = ((Integer)this.ier.get()).intValue() * 4 + this.off;
/* 500 */       if (i < 0 || i >= MoveOrderPullUI.prooms.size())
/*     */         return; 
/* 502 */       MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)MoveOrderPullUI.prooms.get(i);
/*     */       
/* 504 */       boolean sel = s.moveCapacity().has(((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted());
/*     */ 
/*     */       
/* 507 */       GButt.ButtPanel.renderBG(r, sel, false, hoveredIs(), (RECTANGLE)body());
/* 508 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */ 
/*     */ 
/*     */       
/* 512 */       if (s instanceof RoomInstance) {
/* 513 */         RoomInstance ins = (RoomInstance)s;
/* 514 */         (ins.blueprintI()).icon.small.render(r, body().x1() + 4, body().y1() + 4);
/* 515 */         if (hoveredIs() && (KEYS.MAIN()).MOD.isPressed()) {
/* 516 */           (VIEW.s().getWindow()).centererTile.set(ins.body().cX(), ins.body().cY());
/*     */         }
/*     */         
/* 519 */         SETT.OVERLAY().add(ins.mX(), ins.mY());
/*     */       } 
/*     */       
/* 522 */       int x1 = body().x1() + 32;
/*     */       
/* 524 */       for (RESOURCE res : RESOURCES.ALL()) {
/* 525 */         if (s.moveCapacity().has(res) && ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted().has(res)) {
/* 526 */           (res.icon()).small.render(r, x1, body().y1() + 4);
/* 527 */           x1 += 16;
/* 528 */           if (x1 + 16 > body().x2()) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 534 */       super.render(r, ds);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 539 */       int i = ((Integer)this.ier.get()).intValue() * 4 + this.off;
/* 540 */       if (i < 0 || i >= MoveOrderPullUI.prooms.size()) {
/*     */         return;
/*     */       }
/* 543 */       GBox b = (GBox)text;
/*     */       
/* 545 */       GText t = b.text();
/* 546 */       t.add(MoveOrderPullUI.¤¤hold);
/* 547 */       t.insert(0, (KEYS.MAIN()).MOD.repr());
/* 548 */       t.warnify();
/* 549 */       b.add((SPRITE)t);
/* 550 */       b.sep();
/*     */ 
/*     */       
/* 553 */       MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)MoveOrderPullUI.prooms.get(i);
/* 554 */       if (s instanceof RoomInstance) {
/* 555 */         RoomInstance ins = (RoomInstance)s;
/* 556 */         (VIEW.s()).ui.rooms.hover(b, (Room)ins, ins.mX(), ins.mY());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 561 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 566 */       int i = ((Integer)this.ier.get()).intValue() * 4 + this.off;
/* 567 */       if (i < 0 || i >= MoveOrderPullUI.prooms.size())
/*     */         return; 
/* 569 */       MoveJob.ROOM_MOVE_SOURCE s = (MoveJob.ROOM_MOVE_SOURCE)MoveOrderPullUI.prooms.get(i);
/* 570 */       if (((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII] == null) {
/* 571 */         ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII] = new MoveOrderPull((RoomInstance)s, ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted());
/*     */       } else {
/* 573 */         ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII].destSet((RoomInstance)s);
/* 574 */       }  (VIEW.s()).tools.place(null);
/* 575 */       (VIEW.s()).ui.rooms.open((RoomInstance)MoveOrderPullUI.this.room.get());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 580 */       super.clickA();
/*     */     }
/*     */   }
/*     */   
/*     */   private class Placer
/*     */     extends PlacableSingle
/*     */   {
/* 587 */     private final ArrayListGrower<CLICKABLE> ebutts = new ArrayListGrower();
/*     */     private Room hov;
/*     */     private int hx;
/*     */     private int hy;
/*     */     
/*     */     public Placer() {
/* 593 */       super(MoveOrderPullUI.¤¤name);
/*     */       
/* 595 */       this.ebutts.add(new MoveOrderPullUI.PlacerUI());
/*     */     }
/*     */ 
/*     */     
/*     */     public void activate(int ii) {
/* 600 */       MoveOrderPullUI.this.placerII = ii;
/* 601 */       (VIEW.s()).tools.place((PLACABLE)this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void placeFirst(int tx, int ty) {
/* 606 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 607 */       (VIEW.s()).tools.place(null);
/*     */ 
/*     */       
/* 610 */       if (((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII] == null) {
/* 611 */         ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII] = new MoveOrderPull((RoomInstance)r, ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrderPullAccepted());
/*     */       } else {
/* 613 */         ((MoveOrderPull.MoveOrderPullInstance)MoveOrderPullUI.this.source.get()).moveOrdersPull()[MoveOrderPullUI.this.placerII].destSet((RoomInstance)r);
/* 614 */       }  (VIEW.s()).ui.rooms.open((RoomInstance)MoveOrderPullUI.this.room.get());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty) {
/* 623 */       if (tx == VIEW.s().getWindow().tile().x() && ty == VIEW.s().getWindow().tile().y()) {
/* 624 */         SCompFinder.SCompPath pp = (SETT.PATH()).comps.pather.findDest(((RoomInstance)MoveOrderPullUI.this.room.get()).mX(), ((RoomInstance)MoveOrderPullUI.this.room.get()).mY(), tx, ty);
/* 625 */         if (pp == null) {
/* 626 */           return Dic.¤¤Unreachable;
/*     */         }
/*     */       } 
/* 629 */       return pp(tx, ty);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private CharSequence pp(int tx, int ty) {
/* 635 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 636 */       if (r != null && r != MoveOrderPullUI.this.source.get() && r instanceof MoveJob.ROOM_MOVE_SOURCE) {
/* 637 */         this.hov = r;
/* 638 */         this.hx = tx;
/* 639 */         this.hy = ty;
/* 640 */         return null;
/*     */       } 
/* 642 */       return MoveOrderPullUI.¤¤Choose;
/*     */     }
/*     */ 
/*     */     
/*     */     public void placeInfo(GBox b, int tiles) {
/* 647 */       if (this.hov != null) {
/* 648 */         (VIEW.s()).ui.rooms.hover(b, this.hov, this.hx, this.hy);
/* 649 */         this.hov = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE getIcon() {
/* 655 */       return (SPRITE)(UI.icons()).m.crossair;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 660 */       if (pp(fromX, fromY) == null && (SETT.ROOMS()).map.get(fromX, fromY) == (SETT.ROOMS()).map.get(toX, toY))
/* 661 */         return true; 
/* 662 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public LIST<CLICKABLE> getAdditionalButt() {
/* 667 */       return (LIST<CLICKABLE>)this.ebutts;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Paster
/*     */     extends PlacableMulti {
/*     */     MoveOrderPull.MoveOrderPullInstance current;
/*     */     
/*     */     public Paster() {
/* 676 */       super(MoveOrderPullUI.¤¤paster);
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 681 */       Room i = (SETT.ROOMS()).map.get(tx, ty);
/* 682 */       return (i != null && i != this.current && i.blueprint() == ((Room)this.current).blueprint()) ? null : E;
/*     */     }
/*     */ 
/*     */     
/*     */     public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 687 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 688 */       MoveOrderPull.MoveOrderPullInstance i = (MoveOrderPull.MoveOrderPullInstance)r;
/*     */       
/* 690 */       i.copyFrom(this.current);
/*     */       
/* 692 */       if (r.mX(tx, ty) != tx && r.mY(tx, ty) != ty)
/*     */         return; 
/* 694 */       for (int oi = 0; oi < (this.current.moveOrdersPull()).length && oi < (i.moveOrdersPull()).length; oi++) {
/* 695 */         i.moveOrdersPull()[oi] = null;
/* 696 */         MoveOrderPull o = this.current.moveOrdersPull()[oi];
/*     */         
/* 698 */         if (o != null && o.source() != null) {
/* 699 */           i.moveOrdersPull()[oi] = new MoveOrderPull(o.sourceI(), i.moveOrderPullAccepted());
/* 700 */           (i.moveOrdersPull()[oi]).pullLimit = o.pullLimit;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 707 */       Room i = (SETT.ROOMS()).map.get(fromX, fromY);
/* 708 */       return (i != null && i.isSame(fromX, fromY, toX, toY) && i != this.current && i.blueprint() == ((Room)this.current).blueprint());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */