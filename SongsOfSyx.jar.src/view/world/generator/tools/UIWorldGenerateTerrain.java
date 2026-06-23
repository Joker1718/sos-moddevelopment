/*     */ package view.world.generator.tools;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import world.WORLD;
/*     */ import world.WorldGen;
/*     */ 
/*     */ public class UIWorldGenerateTerrain extends GuiSection {
/*  28 */   public static CharSequence ¤¤MapType = "choose map type";
/*  29 */   private static CharSequence ¤¤Random = "Random";
/*     */   
/*  31 */   private static CharSequence ¤¤latitude = "¤latitude";
/*  32 */   private static CharSequence ¤¤nort = "¤northern";
/*  33 */   private static CharSequence ¤¤south = "¤southern";
/*     */   
/*  35 */   private static CharSequence ¤¤seed = "¤Random Seed"; private int ttt;
/*     */   
/*     */   static {
/*  38 */     D.ts(UIWorldGenerateTerrain.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIWorldGenerateTerrain(final WorldGen spec) {
/*  48 */     GuiSection s = new GuiSection();
/*  49 */     final RMapType tt = new RMapType();
/*  50 */     s.add((RENDEROBJ)tt);
/*     */     
/*  52 */     final WorldGen.WorldGenMapType[] types = WorldGen.WorldGenMapType.getAll(WORLD.TWIDTH());
/*     */     
/*  54 */     this.ttt = types.length;
/*  55 */     spec.map = null;
/*  56 */     s.addRelBody(8, DIR.W, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_left)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  60 */             UIWorldGenerateTerrain.this.ttt--;
/*  61 */             if (UIWorldGenerateTerrain.this.ttt < 0)
/*  62 */               UIWorldGenerateTerrain.this.ttt = types.length; 
/*  63 */             tt.type = (UIWorldGenerateTerrain.this.ttt < types.length) ? types[UIWorldGenerateTerrain.this.ttt] : null;
/*  64 */             spec.map = (UIWorldGenerateTerrain.this.ttt < types.length) ? (types[UIWorldGenerateTerrain.this.ttt]).name : null;
/*  65 */             super.clickA();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  70 */     s.addRelBody(8, DIR.E, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  74 */             UIWorldGenerateTerrain.this.ttt++;
/*  75 */             if (UIWorldGenerateTerrain.this.ttt > types.length)
/*  76 */               UIWorldGenerateTerrain.this.ttt = 0; 
/*  77 */             tt.type = (UIWorldGenerateTerrain.this.ttt < types.length) ? types[UIWorldGenerateTerrain.this.ttt] : null;
/*  78 */             spec.map = (UIWorldGenerateTerrain.this.ttt < types.length) ? (types[UIWorldGenerateTerrain.this.ttt]).name : null;
/*  79 */             super.clickA();
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/*  85 */     addRelBody(16, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     addRelBody(16, DIR.S, (RENDEROBJ)new GHeader(¤¤latitude));
/*     */     
/*  92 */     final INT.INTE lat = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/*  96 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 101 */           return 100;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 106 */           return (int)Math.round(spec.lat * 100.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 111 */           spec.lat = t / 100.0D;
/*     */         }
/*     */       };
/*     */     
/* 115 */     GSliderInt gSliderInt = new GSliderInt(lat, 180, true)
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 118 */           GBox b = (GBox)text;
/* 119 */           b.add((SPRITE)GFORMAT.percGood(b.text(), lat.getD()));
/*     */         }
/*     */       };
/*     */     
/* 123 */     addRelBody(8, DIR.S, (RENDEROBJ)gSliderInt);
/*     */     
/* 125 */     addRightC(16, (SPRITE)new GText((UI.FONT()).S, ¤¤nort));
/*     */     
/* 127 */     GText t = new GText((UI.FONT()).S, ¤¤south);
/*     */     
/* 129 */     int y1 = getLastY1();
/*     */     
/* 131 */     add((SPRITE)t, gSliderInt.body().x1() - 16 - t.width(), y1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     addRelBody(16, DIR.S, (RENDEROBJ)new GHeader(¤¤seed));
/*     */ 
/*     */     
/* 139 */     GInput seed = new GInput(new StringInputSprite(10, (UI.FONT()).M)
/*     */         {
/*     */           protected void acceptChar(char c) {
/* 142 */             if (c >= '0' && c <= '9') {
/* 143 */               String str; super.acceptChar(c);
/* 144 */               int se = RND.seed();
/* 145 */               Str str1 = text();
/* 146 */               if (str1.length() > 10)
/* 147 */                 str = String.valueOf(str1).substring(0, 10); 
/*     */               try {
/* 149 */                 se = Integer.parseInt(String.valueOf(str));
/* 150 */                 spec.seed = se;
/* 151 */                 RND.setSeed(se);
/*     */               }
/* 153 */               catch (Exception e) {
/* 154 */                 text().clear().add('1');
/*     */               } 
/*     */             } 
/*     */           }
/*     */         })
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 161 */           GCOLOR.UI().bg().render(r, (RECTANGLE)this.body);
/* 162 */           super.render(r, ds, isActive, isSelected, isHovered);
/*     */         }
/*     */       };
/* 165 */     seed.text().clear().add(spec.seed);
/* 166 */     addRelBody(16, DIR.S, (RENDEROBJ)seed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class RMapType
/*     */     extends RENDEROBJ.RenderImp
/*     */   {
/*     */     private final GText text;
/*     */ 
/*     */ 
/*     */     
/*     */     private WorldGen.WorldGenMapType type;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RMapType() {
/* 186 */       this.body.setDim(210.0D, 210.0D);
/* 187 */       this.text = new GText((UI.FONT()).M, UIWorldGenerateTerrain.¤¤Random);
/* 188 */       this.text.setMultipleLines(true);
/* 189 */       this.text.setMaxWidth(200);
/* 190 */       this.text.adjustWidth();
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 195 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 196 */       GCOLOR.UI().bg(true, false, false).render(r, (RECTANGLE)this.body, -1);
/* 197 */       if (this.type == null) {
/* 198 */         this.text.renderC(r, (RECTANGLE)this.body);
/*     */       } else {
/* 200 */         this.type.render(r, body().x1() + 5, body().y1() + 5, 2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\tools\UIWorldGenerateTerrain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */