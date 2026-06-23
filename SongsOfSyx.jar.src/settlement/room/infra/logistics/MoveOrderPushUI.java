/*     */ package settlement.room.infra.logistics;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSingle;
/*     */ 
/*     */ public class MoveOrderPushUI extends GuiSection {
/*  36 */   private static CharSequence ¤¤notSet = "not set";
/*  37 */   private static CharSequence ¤¤notSetC = "Click to set a storage site to push to.";
/*  38 */   private static CharSequence ¤¤setC = "Click to go to push destination.";
/*  39 */   private static CharSequence ¤¤issue = "Click to issue a push order, which will deliver resources to another storage site.";
/*  40 */   private static CharSequence ¤¤name = "¤Push Destination";
/*  41 */   private static CharSequence ¤¤Choose = "¤Choose a storage site to push to.";
/*  42 */   private static CharSequence ¤¤NoneSeclected = "¤No push destinations have been set.";
/*  43 */   private static CharSequence ¤¤Limit = "¤Push Limit";
/*  44 */   private static CharSequence ¤¤LimitD = "¤Only push when the destination storage utilization is below this limit.";
/*     */   private final GETTER<? extends MoveOrderPush.MoveOrderPushInstance> source;
/*     */   private final GETTER<? extends RoomInstance> room;
/*     */   
/*     */   static {
/*  49 */     D.ts(MoveOrderPushUI.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public MoveOrderPushUI(final GETTER<? extends MoveOrderPush.MoveOrderPushInstance> source, GETTER<? extends RoomInstance> room, int orderAm) {
/*  54 */     this.source = source;
/*  55 */     this.room = room;
/*  56 */     final Placer placer = new Placer();
/*  57 */     final Detail popup = new Detail(placer);
/*     */     
/*  59 */     for (int i = 0; i < orderAm; i++) {
/*     */       
/*  61 */       final int oi = i;
/*     */ 
/*     */ 
/*     */       
/*  65 */       CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(48, 48)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */           {
/*  69 */             GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*  70 */             if (((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi] == null) {
/*  71 */               (UI.icons()).m.storage_push.renderC(r, this.body.cX(), this.body.cY());
/*  72 */               GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */               
/*     */               return;
/*     */             } 
/*  76 */             MoveOrderPush o = ((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi];
/*     */             
/*  78 */             if (isHovered && o.destI() != null) {
/*  79 */               SETT.OVERLAY().add(o.destI().mX(), o.destI().mY());
/*     */             }
/*     */             
/*  82 */             if (o.problem((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/*  83 */               (GCOLOR.UI()).BAD.hovered.bind();
/*  84 */             } else if (o.warning((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/*  85 */               (GCOLOR.UI()).SOSO.hovered.bind();
/*     */             } else {
/*  87 */               (GCOLOR.UI()).GOOD.hovered.bind();
/*     */             } 
/*  89 */             (UI.icons()).s.alert.renderC(r, body().cX(), this.body.cY());
/*  90 */             COLOR.unbind();
/*  91 */             GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/*  96 */             if (((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi] == null) {
/*  97 */               placer.activate(oi);
/*     */             } else {
/*  99 */               (VIEW.inters()).popup.show((RENDEROBJ)popup.get(oi), (CLICKABLE)this);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 105 */             GBox b = (GBox)text;
/* 106 */             b.title(MoveOrderPushUI.¤¤name);
/* 107 */             MoveOrderPush o = ((MoveOrderPush.MoveOrderPushInstance)source.get()).moveOrdersPush()[oi];
/* 108 */             if (o == null) {
/* 109 */               b.text(MoveOrderPushUI.¤¤issue);
/*     */               return;
/*     */             } 
/* 112 */             b.textLL(MoveOrderPushUI.¤¤name);
/* 113 */             b.tab(6);
/* 114 */             if (o.destI() == null) {
/* 115 */               b.error(MoveOrderPushUI.¤¤notSet);
/*     */             } else {
/* 117 */               b.text((CharSequence)o.destI().name());
/*     */             } 
/* 119 */             b.NL();
/*     */             
/* 121 */             if (o.problem((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/* 122 */               b.error(o.problem((MoveOrderPush.MoveOrderPushInstance)source.get()));
/* 123 */             } else if (o.warning((MoveOrderPush.MoveOrderPushInstance)source.get()) != null) {
/* 124 */               b.add((SPRITE)b.text().warnify().add(o.warning((MoveOrderPush.MoveOrderPushInstance)source.get())));
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 130 */       addGrid((RENDEROBJ)clickableAbs, i, 4, 0, 0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private class Detail
/*     */   {
/*     */     private MoveOrderPush o;
/* 137 */     private final GuiSection section = new GuiSection();
/*     */     
/*     */     private int oi;
/*     */     
/*     */     Detail(final MoveOrderPushUI.Placer placer) {
/* 142 */       this.section.add((RENDEROBJ)(new HOVERABLE.Sprite(placer.getIcon())).hoverInfoSet(placer.name()), 0, this.section.body().y2() + 4);
/* 143 */       this.section.addRightCAbs(48, (RENDEROBJ)new CLICKABLE.ClickableAbs(200, 32)
/*     */           {
/* 145 */             final GText t = new GText((UI.FONT()).S, 24);
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 149 */               GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 150 */               this.t.setMaxWidth(180);
/* 151 */               this.t.setMultipleLines(false);
/* 152 */               this.t.clear();
/* 153 */               this.t.normalify();
/* 154 */               if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 155 */                 this.t.add(MoveOrderPushUI.¤¤notSet);
/* 156 */                 this.t.errorify();
/*     */               } else {
/* 158 */                 this.t.add((CharSequence)MoveOrderPushUI.Detail.this.o.destI().name());
/*     */               } 
/* 160 */               this.t.adjustWidth();
/* 161 */               this.t.renderC(r, (RECTANGLE)this.body);
/* 162 */               GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 167 */               text.title(placer.name());
/* 168 */               if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 169 */                 text.text(MoveOrderPushUI.¤¤notSetC);
/*     */               } else {
/* 171 */                 text.text(MoveOrderPushUI.¤¤setC);
/*     */               } 
/* 173 */               super.hoverInfoGet(text);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 178 */               if (MoveOrderPushUI.Detail.this.o.dest() == null) {
/* 179 */                 placer.activate(MoveOrderPushUI.Detail.this.oi);
/*     */               } else {
/* 181 */                 (VIEW.s().getWindow()).centererTile.set(MoveOrderPushUI.Detail.this.o.destI().body().cX(), MoveOrderPushUI.Detail.this.o.destI().body().cY());
/*     */               } 
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 188 */       RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(300, 64) {
/* 189 */           GText t = new GText((UI.FONT()).S, 128);
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, float ds) {
/* 193 */             this.t.clear();
/* 194 */             this.t.setMultipleLines(true);
/* 195 */             this.t.setMaxWidth(280);
/* 196 */             if (MoveOrderPushUI.Detail.this.o.problem((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()) != null) {
/* 197 */               this.t.add(MoveOrderPushUI.Detail.this.o.problem((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()));
/* 198 */               this.t.errorify();
/* 199 */             } else if (MoveOrderPushUI.Detail.this.o.warning((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()) != null) {
/* 200 */               this.t.add(MoveOrderPushUI.Detail.this.o.warning((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()));
/* 201 */               this.t.warnify();
/*     */             } 
/* 203 */             this.t.adjustWidth();
/* 204 */             this.t.render(r, this.body.x1(), this.body.y1());
/*     */           }
/*     */         };
/* 207 */       this.section.add((RENDEROBJ)renderImp, 0, this.section.body().y2() + 4);
/*     */ 
/*     */       
/* 210 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 214 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 219 */             return 50;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 224 */             return MoveOrderPushUI.Detail.this.o.limit / 2;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 229 */             MoveOrderPushUI.Detail.this.o.limit = (byte)(t * 2);
/*     */           }
/*     */         };
/*     */       
/* 233 */       GSliderInt sl = new GSliderInt(ii, 160, false)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 237 */             GBox b = (GBox)text;
/* 238 */             b.title(MoveOrderPushUI.¤¤Limit);
/* 239 */             b.text(MoveOrderPushUI.¤¤LimitD);
/*     */ 
/*     */             
/* 242 */             b.NL();
/* 243 */             b.add((SPRITE)GFORMAT.perc(b.text(), MoveOrderPushUI.Detail.this.o.limit / 100.0D));
/* 244 */             b.NL();
/*     */             
/* 246 */             if (MoveOrderPushUI.Detail.this.o.dest() != null) {
/* 247 */               for (RESOURCE res : RESOURCES.ALL()) {
/* 248 */                 if (MoveOrderPushUI.Detail.this.o.dest().moveCapacity().has(res) && ((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()).moveOrderPushAvailable().has(res)) {
/* 249 */                   double am = MoveOrderPushUI.Detail.this.o.dest().storedD(res);
/* 250 */                   b.add((SPRITE)res.icon());
/* 251 */                   b.add((SPRITE)GFORMAT.perc(b.text(), am));
/* 252 */                   b.NL();
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 260 */       sl.addRelBody(8, DIR.W, (RENDEROBJ)new GHeader(MoveOrderPushUI.¤¤Limit));
/*     */       
/* 262 */       this.section.addRelBody(6, DIR.S, (RENDEROBJ)sl);
/*     */       
/* 264 */       this.section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤remove)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 268 */               ((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()).moveOrdersPush()[MoveOrderPushUI.Detail.this.oi] = null;
/* 269 */               (VIEW.inters()).popup.close();
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public GuiSection get(int oi) {
/* 276 */       this.oi = oi;
/* 277 */       this.o = ((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[oi];
/* 278 */       return this.section;
/*     */     }
/*     */   }
/*     */   
/*     */   public class Placer
/*     */     extends PlacableSingle
/*     */   {
/*     */     private Room hov;
/*     */     private int hx;
/*     */     private int hy;
/*     */     private int ii;
/*     */     
/*     */     public Placer() {
/* 291 */       super(MoveOrderPushUI.¤¤name);
/*     */     }
/*     */     
/*     */     public void activate(int ii) {
/* 295 */       this.ii = ii;
/* 296 */       (VIEW.s()).tools.place((PLACABLE)this);
/*     */     }
/*     */ 
/*     */     
/*     */     public void placeFirst(int tx, int ty) {
/* 301 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 302 */       (VIEW.s()).tools.place(null);
/*     */ 
/*     */       
/* 305 */       if (((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[this.ii] == null) {
/* 306 */         ((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[this.ii] = new MoveOrderPush((RoomInstance)r);
/*     */       } else {
/* 308 */         ((MoveOrderPush.MoveOrderPushInstance)MoveOrderPushUI.this.source.get()).moveOrdersPush()[this.ii].destSet((RoomInstance)r);
/* 309 */       }  (VIEW.s()).ui.rooms.open((RoomInstance)MoveOrderPushUI.this.room.get());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public CharSequence isPlacable(int tx, int ty) {
/* 315 */       if (tx == VIEW.s().getWindow().tile().x() && ty == VIEW.s().getWindow().tile().y()) {
/* 316 */         SCompFinder.SCompPath pp = (SETT.PATH()).comps.pather.findDest(((RoomInstance)MoveOrderPushUI.this.room.get()).mX(), ((RoomInstance)MoveOrderPushUI.this.room.get()).mY(), tx, ty);
/* 317 */         if (pp == null) {
/* 318 */           return Dic.¤¤Unreachable;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 323 */       return pp(tx, ty);
/*     */     }
/*     */ 
/*     */     
/*     */     private CharSequence pp(int tx, int ty) {
/* 328 */       Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 329 */       this.hov = null;
/* 330 */       if (r != null && r != MoveOrderPushUI.this.source.get() && r instanceof MoveJob.ROOM_MOVE_DEST) {
/* 331 */         this.hov = r;
/* 332 */         this.hx = tx;
/* 333 */         this.hy = ty;
/* 334 */         return null;
/*     */       } 
/* 336 */       return MoveOrderPushUI.¤¤Choose;
/*     */     }
/*     */ 
/*     */     
/*     */     public void placeInfo(GBox b, int tiles) {
/* 341 */       if (this.hov != null) {
/* 342 */         (VIEW.s()).ui.rooms.hover(b, this.hov, this.hx, this.hy);
/* 343 */         this.hov = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public SPRITE getIcon() {
/* 349 */       return (SPRITE)(UI.icons()).m.crossair;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 354 */       if (pp(fromX, fromY) == null && (SETT.ROOMS()).map.get(fromX, fromY) == (SETT.ROOMS()).map.get(toX, toY))
/* 355 */         return true; 
/* 356 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static CharSequence problem(MoveOrderPush.MoveOrderPushInstance i) {
/* 361 */     boolean isOk = false;
/* 362 */     boolean has = false;
/* 363 */     CharSequence prob = null; byte b; int j; MoveOrderPush[] arrayOfMoveOrderPush;
/* 364 */     for (j = (arrayOfMoveOrderPush = i.moveOrdersPush()).length, b = 0; b < j; ) { MoveOrderPush o = arrayOfMoveOrderPush[b];
/* 365 */       if (o != null) {
/* 366 */         has = true;
/* 367 */         CharSequence p = o.problem(i);
/* 368 */         if (p != null) {
/* 369 */           prob = p;
/*     */         } else {
/* 371 */           isOk = true;
/*     */         } 
/*     */       }  b++; }
/* 374 */      if (!isOk) {
/* 375 */       return prob;
/*     */     }
/* 377 */     if (!has) {
/* 378 */       return ¤¤NoneSeclected;
/*     */     }
/* 380 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */