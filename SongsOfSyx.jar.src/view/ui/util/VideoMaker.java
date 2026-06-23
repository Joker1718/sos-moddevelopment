/*     */ package view.ui.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.CORE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.VIDEO_MAKER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInputInt;
/*     */ import util.gui.misc.GText;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.subview.GameWindow;
/*     */ import world.WORLD;
/*     */ 
/*     */ public class VideoMaker {
/*  35 */   private final Placer start = new Placer("start area");
/*  36 */   private final Placer end = new Placer("end area");
/*  37 */   private final GuiSection s = new GuiSection();
/*     */   
/*     */   private final Mode world;
/*     */   private final Mode sett;
/*     */   private final Mode battle;
/*  42 */   private final INT.IntImp duration = new INT.IntImp();
/*     */   
/*     */   private Mode current;
/*     */ 
/*     */   
/*     */   public VideoMaker() {
/*  48 */     this.world = new Mode()
/*     */       {
/*     */         
/*     */         public GameWindow window()
/*     */         {
/*  53 */           return (VIEW.world()).window;
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(RECTANGLE bounds) {
/*  58 */           WORLD.OVERLAY().hide();
/*  59 */           boolean t = (WORLD.FOW()).toggled.is();
/*  60 */           (WORLD.FOW()).toggled.set(false);
/*  61 */           GAME.world().render(CORE.renderer(), 0.0F, 0, bounds, 0, 0);
/*  62 */           (WORLD.FOW()).toggled.set(t);
/*     */         }
/*     */       };
/*     */     
/*  66 */     this.sett = new Mode()
/*     */       {
/*     */         public GameWindow window()
/*     */         {
/*  70 */           return VIEW.s().getWindow();
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(RECTANGLE bounds) {
/*  75 */           GAME.s().render(CORE.renderer(), 0.0F, 0, bounds, 0, 0, UIMinimapSettConfig.NORMAL);
/*     */         }
/*     */       };
/*     */     
/*  79 */     this.battle = new Mode()
/*     */       {
/*     */         public GameWindow window()
/*     */         {
/*  83 */           return VIEW.b().getWindow();
/*     */         }
/*     */ 
/*     */         
/*     */         public void render(RECTANGLE bounds) {
/*  88 */           GAME.s().render(CORE.renderer(), 0.0F, 0, bounds, 0, 0, UIMinimapSettConfig.NORMAL);
/*     */         }
/*     */       };
/*     */     byte b;
/*     */     int i;
/*     */     Placer[] arrayOfPlacer;
/*  94 */     for (i = (arrayOfPlacer = new Placer[] { this.start, this.end }, ).length, b = 0; b < i; ) { final Placer p = arrayOfPlacer[b];
/*  95 */       GuiSection guiSection = new GuiSection();
/*     */       
/*  97 */       guiSection.add((SPRITE)new GText((UI.FONT()).S, p.name), 0, 0);
/*     */       
/*  99 */       guiSection.addRightCAbs(100, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 103 */               p.set();
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */       
/* 109 */       guiSection.addRightC(16, (UI.FONT()).S.getText("x1"));
/* 110 */       guiSection.addRightC(4, (RENDEROBJ)new GInputInt((INT.INTE)p.x1));
/*     */       
/* 112 */       guiSection.addRightC(16, (UI.FONT()).S.getText("width"));
/* 113 */       guiSection.addRightC(4, (RENDEROBJ)new GInputInt((INT.INTE)p.w));
/*     */       
/* 115 */       guiSection.addRightC(16, (UI.FONT()).S.getText("y1"));
/* 116 */       guiSection.addRightC(4, (RENDEROBJ)new GInputInt((INT.INTE)p.y1));
/*     */       
/* 118 */       guiSection.addRightC(16, (UI.FONT()).S.getText("height"));
/* 119 */       guiSection.addRightC(4, (RENDEROBJ)new GInputInt((INT.INTE)p.h));
/*     */       
/* 121 */       this.s.addDown(4, (RENDEROBJ)guiSection);
/*     */       
/*     */       b++; }
/*     */     
/* 125 */     GuiSection rr = new GuiSection();
/* 126 */     rr.addRightC(16, (UI.FONT()).S.getText("duration (ms)"));
/* 127 */     rr.addRightC(4, (RENDEROBJ)new GInputInt((INT.INTE)this.duration));
/* 128 */     this.s.addDown(4, (RENDEROBJ)rr);
/*     */ 
/*     */     
/* 131 */     this.s.addRightC(32, (RENDEROBJ)new GButt.ButtPanel("action!")
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 135 */             VideoMaker.this.start.rec.moveX1Y1(VideoMaker.this.start.x1.get(), VideoMaker.this.start.y1.get()).setDim(VideoMaker.this.start.w.get(), VideoMaker.this.start.h.get());
/* 136 */             VideoMaker.this.end.rec.moveX1Y1(VideoMaker.this.end.x1.get(), VideoMaker.this.end.y1.get()).setDim(VideoMaker.this.end.w.get(), VideoMaker.this.end.h.get());
/*     */             
/* 138 */             String f = String.valueOf((PATHS.local()).VIDEO.get().toAbsolutePath()) + String.valueOf((PATHS.local()).VIDEO.get().toAbsolutePath()) + "frame";
/* 139 */             SPRITES.loader().init();
/*     */           }
/*     */         });
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
/* 160 */     IDebugPanel.add("video maker", new ACTION()
/*     */         {
/*     */           
/*     */           public void exe()
/*     */           {
/* 165 */             VideoMaker.this.current = null;
/* 166 */             if (VIEW.s().isActive()) {
/* 167 */               VideoMaker.this.current = VideoMaker.this.sett;
/* 168 */             } else if (VIEW.b().isActive()) {
/* 169 */               VideoMaker.this.current = VideoMaker.this.battle;
/* 170 */             } else if (VIEW.world().isActive()) {
/* 171 */               VideoMaker.this.current = VideoMaker.this.world;
/* 172 */             }  if (VideoMaker.this.current == null) {
/* 173 */               LOG.ln("can't make video for view: " + String.valueOf(VIEW.current()));
/*     */             }
/* 175 */             (VIEW.inters()).popup.show((RENDEROBJ)VideoMaker.this.s, null);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static abstract class Mode
/*     */   {
/*     */     public abstract GameWindow window();
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract void render(RECTANGLE param1RECTANGLE);
/*     */   }
/*     */ 
/*     */   
/*     */   private class Placer
/*     */     extends Interrupter
/*     */   {
/*     */     public final String name;
/*     */     
/* 197 */     private final Rec rec = new Rec();
/* 198 */     private final Rec tmp = new Rec();
/* 199 */     public final INT.IntImp x1 = new INT.IntImp();
/* 200 */     public final INT.IntImp y1 = new INT.IntImp();
/* 201 */     public final INT.IntImp w = new INT.IntImp();
/* 202 */     public final INT.IntImp h = new INT.IntImp();
/*     */     private boolean clicked = false;
/* 204 */     private Coo start = new Coo();
/*     */     
/*     */     public Placer(String name) {
/* 207 */       this.name = name;
/*     */     }
/*     */     
/*     */     void set() {
/* 211 */       this.clicked = false;
/* 212 */       (VIEW.inters()).manager.add(this);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 217 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 222 */       if (button == MButt.LEFT && !this.clicked) {
/* 223 */         this.clicked = true;
/* 224 */         this.start.set(VideoMaker.this.current.window().pixel().x(), VideoMaker.this.current.window().pixel().y());
/*     */       } else {
/*     */         
/* 227 */         hide();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 239 */       if (!this.clicked) {
/* 240 */         return true;
/*     */       }
/* 242 */       GameWindow w = VideoMaker.this.current.window();
/*     */ 
/*     */       
/* 245 */       int x1 = this.rec.x1();
/* 246 */       int y1 = this.rec.y1();
/*     */       
/* 248 */       x1 -= w.pixels().x1();
/* 249 */       y1 -= w.pixels().y1();
/*     */       
/* 251 */       x1 >>= w.zoomout();
/* 252 */       y1 >>= w.zoomout();
/*     */       
/* 254 */       x1 += w.viewWindow().x1();
/* 255 */       y1 += w.viewWindow().y1();
/*     */       
/* 257 */       this.tmp.moveX1Y1(x1, y1);
/* 258 */       this.tmp.setDim((this.rec.width() >> w.zoomout()), (this.rec.height() >> w.zoomout()));
/*     */       
/* 260 */       COLOR.GREEN100.renderFrame((SPRITE_RENDERER)r, (RECTANGLE)this.tmp, 0, 3);
/*     */       
/* 262 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 267 */       if (this.clicked) {
/* 268 */         this.rec.setDim(1.0D);
/* 269 */         this.rec.moveX1Y1((COORDINATE)this.start);
/* 270 */         this.rec.unify(VideoMaker.this.current.window().pixel().x(), VideoMaker.this.current.window().pixel().y());
/*     */         
/* 272 */         int cs = this.rec.cX();
/* 273 */         int cy = this.rec.cY();
/*     */         
/* 275 */         double d = (CORE.getGraphics()).nativeHeight / (CORE.getGraphics()).nativeWidth;
/* 276 */         this.rec.setHeight(this.rec.width() * d);
/*     */         
/* 278 */         this.rec.moveC(cs, cy);
/*     */         
/* 280 */         if (!MButt.LEFT.isDown()) {
/* 281 */           this.clicked = false;
/*     */           
/* 283 */           this.x1.set(this.rec.x1());
/* 284 */           this.y1.set(this.rec.y1());
/* 285 */           this.w.set(this.rec.width());
/* 286 */           this.h.set(this.rec.height());
/*     */ 
/*     */           
/* 289 */           hide();
/* 290 */           (VIEW.inters()).popup.show((RENDEROBJ)VideoMaker.this.s, null);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 298 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\VideoMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */