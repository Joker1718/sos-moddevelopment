/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Files;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.light.PointLight;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Tuple;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.text.D;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScCreditsFame
/*     */   extends GUI.Shadower
/*     */   implements SC
/*     */ {
/*     */   private final CLICKABLE next;
/*     */   private final CLICKABLE prev;
/*  41 */   private int currentScreen = 0;
/*  42 */   private final ArrayListGrower<Screen> all = new ArrayListGrower();
/*     */   
/*  44 */   private final Text sname = (UI.FONT()).H2.getText(200);
/*  45 */   private final Text stitles = (UI.FONT()).M.getText(200);
/*     */   
/*  47 */   static CharSequence ¤¤name = "¤hall of fame";
/*     */   static {
/*  49 */     D.ts(ScCreditsFame.class);
/*     */   }
/*     */   
/*     */   ScCreditsFame(final Menu menu) {
/*  53 */     D.gInit(this);
/*     */     
/*  55 */     MenuScreen screen = new MenuScreen(¤¤name, GUI.labelColor)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  59 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/*     */     
/*  63 */     add((RENDEROBJ)screen);
/*     */     
/*  65 */     this.all.add((Iterable)legends(menu));
/*  66 */     this.all.add((Iterable)heroes(menu));
/*  67 */     this.all.add((Iterable)others());
/*     */     
/*  69 */     this.prev = GUI.getNavButt("<<");
/*  70 */     this.prev.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  73 */             if (ScCreditsFame.this.currentScreen > 0)
/*  74 */               ScCreditsFame.this.currentScreen--; 
/*  75 */             ScCreditsFame.this.prev.activeSet((ScCreditsFame.this.currentScreen > 0));
/*  76 */             ScCreditsFame.this.next.activeSet((ScCreditsFame.this.currentScreen < ScCreditsFame.this.all.size() - 1));
/*     */           }
/*     */         });
/*     */     
/*  80 */     screen.addButt((RENDEROBJ)this.prev);
/*  81 */     this.next = GUI.getNavButt(">>");
/*  82 */     this.next.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  85 */             if (ScCreditsFame.this.currentScreen < ScCreditsFame.this.all.size() - 1)
/*  86 */               ScCreditsFame.this.currentScreen++; 
/*  87 */             ScCreditsFame.this.prev.activeSet((ScCreditsFame.this.currentScreen > 0));
/*  88 */             ScCreditsFame.this.next.activeSet((ScCreditsFame.this.currentScreen < ScCreditsFame.this.all.size() - 1));
/*     */           }
/*     */         });
/*  91 */     screen.addButt((RENDEROBJ)this.next);
/*     */ 
/*     */     
/*  94 */     body().centerX(C.DIM());
/*     */     
/*  96 */     this.prev.activeSet((this.currentScreen > 0));
/*  97 */     this.next.activeSet((this.currentScreen < this.all.size() - 1));
/*     */     
/*  99 */     for (Screen s : this.all) {
/* 100 */       s.body().centerIn(MenuScreen.inner);
/* 101 */       s.body().moveY1(MenuScreen.inner.y1());
/*     */     } 
/*     */   }
/*     */   
/*     */   private LIST<Screen> legends(Menu menu) {
/* 106 */     String[] names = {
/* 107 */         "Jake", 
/* 108 */         "Natalia Jasinska", 
/* 109 */         "Gianluca Borg", 
/* 110 */         "Superwutz", 
/* 111 */         "ProRt", 
/* 112 */         "Connor Bryant", 
/* 113 */         "JollyWarhammer", 
/* 114 */         "Bendigeidfran"
/*     */       };
/* 116 */     String[] descs = {
/* 117 */         "Supreme Developer, Creator of worlds, Bringer of Syxians", 
/* 118 */         "Mistress of soundtracks", 
/* 119 */         "High Councelor, Spokesman of the Plebs, Guardian of History", 
/* 120 */         "Sacred voice of modability, Father of the Agonosh, He whose name is hard to remember", 
/* 121 */         "First knighted, Finder of bugs", 
/* 122 */         "Generous benefactor", 
/* 123 */         "Warrior Monk", 
/* 124 */         "Champion of Art"
/*     */       };
/*     */     
/* 127 */     LinkedList<Screen> screens = new LinkedList();
/* 128 */     Screen current = null;
/* 129 */     final PointLight light = new PointLight();
/* 130 */     light.setRadius(200);
/* 131 */     light.setZ(200);
/* 132 */     double ii = 1.5D;
/* 133 */     light.setRed(ii).setGreen(ii).setBlue(ii);
/*     */     
/* 135 */     for (int i = 0; i < names.length; i++) {
/* 136 */       if (i % 4 == 0) {
/* 137 */         current = new Screen();
/* 138 */         screens.add(current);
/*     */       } 
/*     */       
/* 141 */       final String name = names[i];
/* 142 */       final String desc = descs[i];
/* 143 */       final SPRITE frame = (menu.res.s()).creditsBigFrame;
/* 144 */       final SPRITE ps = (menu.res.s()).creditsBig[i];
/*     */       
/* 146 */       current.addRightC(16, (RENDEROBJ)new HOVERABLE.HoverableAbs((DIMENSION)frame)
/*     */           {
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/* 151 */               if (isHovered) {
/* 152 */                 light.set(this.body.cX(), this.body.cY());
/* 153 */                 light.register();
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 158 */               ps.render(r, this.body.x1(), this.body.y1());
/* 159 */               frame.render(r, this.body.x1(), this.body.y1());
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean hover(COORDINATE mCoo) {
/* 166 */               ScCreditsFame.this.sname.clear();
/* 167 */               if (super.hover(mCoo)) {
/* 168 */                 ScCreditsFame.this.sname.set(name);
/* 169 */                 ScCreditsFame.this.stitles.clear().set(desc);
/* 170 */                 return true;
/*     */               } 
/* 172 */               return false;
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 179 */     return (LIST<Screen>)screens;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<Screen> heroes(Menu menu) {
/* 186 */     String[] names = {
/* 187 */         "Laki 95", 
/* 188 */         "Dr. Kelloggs", 
/* 189 */         "Licher", 
/* 190 */         "Qbjik", 
/* 191 */         "Mathedarius & Daniella", 
/* 192 */         "Sparrow", 
/* 193 */         "Mathias Dietrich", 
/* 194 */         "Felix Ungman"
/*     */       };
/* 196 */     String[] descs = {
/* 197 */         "Bringer of Suggestions", 
/* 198 */         "Titles...", 
/* 199 */         "The King of the People and Protector of Syx", 
/* 200 */         "The Lazy Panda, Lord of Quokkas", 
/* 201 */         "The Wise, The Wolves, Breaker of Chains", 
/* 202 */         "The Sweet, the Chonk, Purrveyor of Mews", 
/* 203 */         "Beacon of the Free", 
/* 204 */         "Shogun"
/*     */       };
/*     */     
/* 207 */     LinkedList<Screen> screens = new LinkedList();
/* 208 */     Screen current = null;
/* 209 */     final PointLight light = new PointLight();
/* 210 */     light.setRadius(150);
/* 211 */     light.setZ(150);
/* 212 */     light.setRed(1.0D).setGreen(1.0D).setBlue(1.0D);
/*     */     
/* 214 */     for (int i = 0; i < names.length; i++) {
/* 215 */       if (i % 10 == 0) {
/* 216 */         current = new Screen();
/* 217 */         screens.add(current);
/*     */       } 
/*     */       
/* 220 */       final String name = names[i];
/* 221 */       final String desc = descs[i];
/* 222 */       final SPRITE frame = (menu.res.s()).creditsSmallFrame;
/* 223 */       final SPRITE ps = (menu.res.s()).creditsSmall[i];
/*     */       
/* 225 */       int x = i % 10 % 5;
/* 226 */       int y = i % 10 / 5;
/*     */       
/* 228 */       current.add((RENDEROBJ)new HOVERABLE.HoverableAbs((DIMENSION)frame)
/*     */           {
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/* 233 */               if (isHovered) {
/* 234 */                 light.set(this.body.cX(), this.body.cY());
/* 235 */                 light.register();
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 240 */               ps.render(r, this.body.x1(), this.body.y1());
/* 241 */               frame.render(r, this.body.x1(), this.body.y1());
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public boolean hover(COORDINATE mCoo) {
/* 248 */               ScCreditsFame.this.sname.clear();
/* 249 */               if (super.hover(mCoo)) {
/* 250 */                 ScCreditsFame.this.sname.set(name);
/* 251 */                 ScCreditsFame.this.stitles.clear().set(desc);
/* 252 */                 return true;
/*     */               } 
/* 254 */               return false;
/*     */             }
/* 256 */           }x * (frame.width() + 20), y * (frame.height() + 8));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 261 */     return (LIST<Screen>)screens;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<Screen> others() {
/* 267 */     final PointLight light = new PointLight();
/* 268 */     double in = 1.0D;
/* 269 */     light.setRed(in).setGreen(in).setBlue(in);
/* 270 */     light.setRadius(900);
/* 271 */     light.setZ(200);
/*     */     
/* 273 */     ArrayListGrower<Tuple.TupleImp<String, String[]>> all = new ArrayListGrower();
/*     */     
/*     */     try {
/* 276 */       all.add(new Tuple.TupleImp(String.valueOf(D.g("nobility")), (new String(Files.readAllBytes((PATHS.BASE()).DATA.get("Nobles")), StandardCharsets.UTF_8)).split(System.lineSeparator())));
/* 277 */       all.add(new Tuple.TupleImp(String.valueOf(D.g("knights")), (new String(Files.readAllBytes((PATHS.BASE()).DATA.get("Knights")), StandardCharsets.UTF_8)).split(System.lineSeparator())));
/* 278 */       all.add(new Tuple.TupleImp(String.valueOf(D.g("citizens")), (new String(Files.readAllBytes((PATHS.BASE()).DATA.get("Citizens")), StandardCharsets.UTF_8)).split(System.lineSeparator())));
/* 279 */     } catch (Exception exception) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     LinkedList<Screen> screens = new LinkedList();
/*     */     
/* 287 */     for (Tuple.TupleImp<String, String[]> t : all) {
/*     */       
/* 289 */       int x1 = GUI.inner.x1();
/* 290 */       int x2 = GUI.inner.x2() + 100;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 296 */       int scale = 2;
/*     */       
/* 298 */       int margin = 20;
/* 299 */       int height = (UI.FONT()).H2.height() * scale;
/*     */       
/* 301 */       int y2 = GUI.inner.y2() - height;
/*     */       
/* 303 */       String[] names = (String[])t.b;
/* 304 */       String title = (String)t.a;
/*     */       
/* 306 */       int i = 0;
/* 307 */       while (i < names.length) {
/*     */         
/* 309 */         Screen s = new Screen()
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds) {
/* 312 */               light.set(GUI.inner.cX(), GUI.inner.cY());
/* 313 */               light.register();
/* 314 */               OPACITY.O99.bind();
/* 315 */               super.render(r, ds);
/* 316 */               OPACITY.unbind();
/*     */             }
/*     */           };
/*     */         
/* 320 */         s.add((RENDEROBJ)new RENDEROBJ.Sprite((SPRITE)(UI.FONT()).H2.getText(title).setScale(2.0D)));
/* 321 */         s.body().moveY1(GUI.inner.y1());
/* 322 */         s.body().centerX(GUI.inner);
/* 323 */         int y1 = s.body().y2() + 10;
/* 324 */         int x = x1;
/* 325 */         while (i < names.length) {
/* 326 */           x += RND.rInt(20);
/* 327 */           RENDEROBJ.Sprite o = new RENDEROBJ.Sprite(new Name(names[i]));
/* 328 */           i++;
/* 329 */           o.setColor(COLOR.WHITE100);
/* 330 */           if (x + o.body().width() > x2) {
/* 331 */             y1 += height;
/* 332 */             if (y1 > y2)
/*     */               break; 
/* 334 */             x = x1 + RND.rInt(30);
/*     */           } 
/* 336 */           o.body().moveX1(x).moveY1((y1 + RND.rInt(20)));
/* 337 */           x += o.body().width() + margin;
/* 338 */           s.add((RENDEROBJ)o);
/*     */         } 
/*     */         
/* 341 */         screens.add(s);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 348 */     return (LIST<Screen>)screens;
/*     */   }
/*     */   
/*     */   private static final class Name
/*     */     implements SPRITE
/*     */   {
/*     */     private final int width;
/*     */     private final CharSequence name;
/*     */     
/*     */     Name(CharSequence s) {
/* 358 */       this.name = s;
/* 359 */       this.width = (UI.FONT()).H2.getDim(s).x() * 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 364 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 369 */       return (UI.FONT()).H2.height() * 2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 375 */       (UI.FONT()).H2.render(r, this.name, X1, Y1, 2.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 388 */     super.render(r, ds);
/* 389 */     if (this.sname.length() != 0) {
/*     */       
/* 391 */       GUI.COLORS.label.bind();
/* 392 */       this.sname.renderC(r, body().cX(), GUI.inner.y2());
/* 393 */       GUI.COLORS.copper.bind();
/* 394 */       this.stitles.renderC(r, body().cX(), GUI.inner.y2() + this.sname.height() + 4);
/* 395 */       COLOR.unbind();
/* 396 */       this.sname.clear();
/* 397 */       this.stitles.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBackground(Background back, float ds, COORDINATE mCoo) {
/* 405 */     back.renderFame((SPRITE_RENDERER)CORE.renderer(), ds, mCoo, ((Screen)this.all.get(this.currentScreen)).ran);
/* 406 */     ((Screen)this.all.get(this.currentScreen)).render((SPRITE_RENDERER)CORE.renderer(), ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 412 */     ((Screen)this.all.get(this.currentScreen)).hover(mCoo);
/* 413 */     return super.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 418 */     menu.switchScreen(menu.main);
/* 419 */     return true;
/*     */   }
/*     */   
/*     */   private static class Screen extends GuiSection {
/*     */     private Screen() {
/* 424 */       this.ran = RND.rFloat();
/*     */     }
/*     */     
/*     */     final double ran;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCreditsFame.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */