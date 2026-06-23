/*     */ package view.ui.profile;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.common.BitmapSpriteEditor;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class UIFactionBanner extends GuiSection {
/*  19 */   private static CharSequence ¤¤Banner = "¤Banner";
/*  20 */   private static CharSequence ¤¤BackGround = "¤Background";
/*  21 */   private static CharSequence ¤¤Foreground = "¤Foreground";
/*  22 */   private static CharSequence ¤¤Pole = "¤Pole";
/*  23 */   private static CharSequence ¤¤Border = "¤Border"; private final Faction f;
/*     */   
/*     */   static {
/*  26 */     D.ts(UIFactionBanner.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UIFactionBanner(Faction f) {
/*  32 */     this.f = f;
/*  33 */     add((RENDEROBJ)bannerHeader());
/*  34 */     addRelBody(8, DIR.S, (RENDEROBJ)banner());
/*  35 */     addRelBody(16, DIR.E, (RENDEROBJ)colors());
/*     */   }
/*     */   
/*     */   private GuiSection banner() {
/*  39 */     return (GuiSection)new BitmapSpriteEditor((this.f.banner()).sprite);
/*     */   }
/*     */   
/*     */   private GuiSection bannerHeader() {
/*  43 */     final FBanner b = this.f.banner();
/*  44 */     GuiSection s = new GuiSection();
/*  45 */     s.add(b.HUGE, 0, 0);
/*  46 */     s.addRightC(8, b.BIG);
/*  47 */     s.addRightC(8, b.MEDIUM);
/*     */     
/*  49 */     s.addRightC(20, (RENDEROBJ)new GHeader(¤¤Banner));
/*  50 */     s.addRightC(16, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_left)
/*     */         {
/*     */           protected void clickA() {
/*  53 */             b.bannerTypeSet(b.bannerType() - 1);
/*     */           }
/*     */         });
/*  56 */     s.addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA() {
/*  59 */             b.bannerTypeSet(b.bannerType() + 1);
/*     */           }
/*     */         });
/*  62 */     return s;
/*     */   }
/*     */   
/*     */   private GuiSection colors() {
/*  66 */     final FBanner b = this.f.banner();
/*  67 */     GuiSection s = new GuiSection();
/*  68 */     s.add((RENDEROBJ)new GColorPicker(false, ¤¤BackGround)
/*     */         {
/*     */           
/*     */           public ColorImp color()
/*     */           {
/*  73 */             return b.colorBG();
/*     */           }
/*     */ 
/*     */           
/*     */           public void change() {
/*  78 */             for (Region r : UIFactionBanner.this.f.realm().all())
/*  79 */               WORLD.MINIMAP().updateRegion(r); 
/*     */           }
/*     */         });
/*  82 */     s.addDownC(8, (RENDEROBJ)new GColorPicker(false, ¤¤Foreground)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/*  86 */             return b.colorFG();
/*     */           }
/*     */         });
/*  89 */     s.addDownC(8, (RENDEROBJ)new GColorPicker(false, ¤¤Border)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/*  93 */             return b.colorBorder();
/*     */           }
/*     */         });
/*  96 */     s.addDownC(8, (RENDEROBJ)new GColorPicker(false, ¤¤Pole)
/*     */         {
/*     */           public ColorImp color()
/*     */           {
/* 100 */             return b.colorPole();
/*     */           }
/*     */         });
/* 103 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\UIFactionBanner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */