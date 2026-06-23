/*     */ package settlement.tilemap.terrain;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.paths.PATHS;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.game.Sheet;
/*     */ import init.sprite.game.SheetData;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.TileTexture;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
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
/*     */ final class Sprites
/*     */ {
/*     */   private final TILE_SHEET ssmall;
/*     */   private final TILE_SHEET smedium;
/*     */   private final SheetPair small;
/*     */   private final SheetPair medium;
/*     */   private final SheetPair big;
/* 559 */   private final TForestTop top = new TForestTop();
/* 560 */   private final TForestLeafs leafs = new TForestLeafs();
/* 561 */   private final Swayer swayer = new Swayer();
/*     */ 
/*     */   
/*     */   private Sprites() throws IOException {
/* 565 */     Path p = PATHS.SPRITE_SETTLEMENT_MAP().get("Tree");
/*     */     
/* 567 */     this.ssmall = (new ComposerThings.ITileSheet(p, 720, 296)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 571 */           ComposerDests.Tile t = d.s16;
/* 572 */           s.singles.init(0, 0, 1, 1, 16, 1, (ComposerDests.Dest)t);
/* 573 */           s.singles.paste(1, true);
/* 574 */           return t.saveGame();
/*     */         }
/* 576 */       }).get();
/*     */ 
/*     */     
/* 579 */     this.smedium = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 583 */           ComposerDests.Tile t = d.s16;
/* 584 */           s.combo.init(0, s.singles.body().y2(), 8, 2, 2, (ComposerDests.Dest)t);
/* 585 */           for (int i = 0; i < 16; i++) {
/* 586 */             s.combo.setVar(i).paste(1, true);
/*     */           }
/* 588 */           return t.saveGame();
/*     */         }
/* 590 */       }).get();
/*     */     
/* 592 */     TILE_SHEET large = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 596 */           ComposerDests.Tile t = d.s16;
/*     */           
/* 598 */           s.combo.init(0, s.combo.body().y2(), 6, 3, 3, (ComposerDests.Dest)t);
/* 599 */           for (int i = 0; i < 16; i++) {
/* 600 */             s.combo.setVar(i).paste(1, true);
/*     */           }
/*     */           
/* 603 */           return t.saveGame();
/*     */         }
/* 605 */       }).get();
/*     */     
/* 607 */     this.small = make((SheetType)SheetType.s1x1, this.ssmall);
/* 608 */     this.small.d.shadowLength = 5;
/* 609 */     this.small.d.shadowHeight = 2;
/*     */     
/* 611 */     this.medium = make((SheetType)SheetType.s2x2, this.smedium);
/* 612 */     this.medium.d.shadowLength = 10;
/* 613 */     this.medium.d.shadowHeight = 6;
/* 614 */     this.big = make((SheetType)SheetType.s3x3, large);
/* 615 */     this.big.d.shadowLength = 10;
/* 616 */     this.big.d.shadowHeight = 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 621 */     this.top.update(ds);
/* 622 */     this.leafs.update(ds);
/* 623 */     this.swayer.update();
/*     */   }
/*     */   
/*     */   private SheetPair make(SheetType type, TILE_SHEET sh) {
/* 627 */     FSheet fSheet = new FSheet(type, sh);
/* 628 */     ArrayList<Sheet> shh = new ArrayList(fSheet);
/* 629 */     SPRITES.GAME().add(type, (LIST)shh, "_TREE");
/* 630 */     return new SheetPair((Sheet)shh.get(0), new SheetData());
/*     */   }
/*     */   
/*     */   private static class FSheet extends Sheet.Imp {
/*     */     private final ColorImp col;
/*     */     
/*     */     public FSheet(SheetType type, TILE_SHEET s) {
/* 637 */       super(type, s, false);
/*     */ 
/*     */       
/* 640 */       this.col = new ColorImp();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SheetData da, int x, int y, RenderData.RenderIterator it, SPRITE_RENDERER sr, int tile, int random, double degrade) {
/* 646 */       int ran = random;
/* 647 */       int colI = ran >> 7 & 0x1F;
/* 648 */       int swI = ran >> 10 & 0x3F;
/*     */ 
/*     */       
/* 651 */       if (degrade > 0.0D) {
/*     */         
/* 653 */         this.col.interpolate((SETT.TERRAIN()).colors.tree.get(random), (SETT.TERRAIN()).colors.tree.dry(random), degrade);
/*     */       } else {
/* 655 */         this.col.set((SETT.TERRAIN()).colors.tree.get(random));
/*     */       } 
/* 657 */       this.col.bind();
/* 658 */       x += (SETT.TERRAIN()).TREES.sprites.swayer.dx[swI];
/* 659 */       y -= (SETT.TERRAIN()).TREES.sprites.swayer.dy[swI];
/* 660 */       int offX = it.oX() + (SETT.TERRAIN()).TREES.sprites.swayer.dx[swI];
/* 661 */       int offY = it.oY() - (SETT.TERRAIN()).TREES.sprites.swayer.dy[swI];
/*     */       
/* 663 */       it.setOff(offX, offY);
/* 664 */       this.sheet.render(sr, tile, x, y);
/* 665 */       if ((S.get()).graphics.get() > 0) {
/* 666 */         (SETT.TERRAIN()).TREES.sprites.top.render(x, y, sr, 0, it, colI);
/* 667 */         (SETT.TERRAIN()).TREES.sprites.leafs.render(x, y, it.ran());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 672 */       COLOR.unbind();
/* 673 */       it.countVegetation();
/* 674 */       it.countVegetation();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderShadow(SheetData da, int x, int y, RenderData.RenderIterator it, ShadowBatch shadow, int tile, int random) {
/* 680 */       super.renderShadow(da, x, y, it, shadow, tile, random);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TForestLeafs
/*     */   {
/*     */     private static final int AMOUNT = 32;
/*     */     private final LeafTile[] tiles;
/* 688 */     private double time = (RND.rFloat() * 10000.0F);
/* 689 */     private int t = 0;
/* 690 */     private int am = 4;
/*     */     
/*     */     private TForestLeafs() {
/* 693 */       this.tiles = new LeafTile[32];
/* 694 */       for (int i = 0; i < 32; i++) {
/* 695 */         this.tiles[i] = new LeafTile();
/*     */       }
/* 697 */       update(0.0D);
/*     */     }
/*     */     
/*     */     public void render(int x, int y, int ran) {
/* 701 */       this.tiles[ran & 0x1F].render(x, y, this.t, this.am);
/*     */     }
/*     */ 
/*     */     
/*     */     void update(double ds) {
/* 706 */       this.am = 4;
/* 707 */       if (SETT.WEATHER() != null) {
/* 708 */         this.time += ds * (1.0D + 3.0D * (SETT.WEATHER()).wind.getD());
/* 709 */         double winter = 1.0D - (SETT.WEATHER()).growth.getD();
/* 710 */         if (winter > 0.5D && !(SETT.WEATHER()).growth.isAutumn()) {
/* 711 */           this.am = (int)((1.0D - (winter - 0.5D) * 2.0D) * 4.0D);
/*     */         }
/*     */       } 
/*     */       
/* 715 */       if (this.time > 10000.0D)
/* 716 */         this.time -= 10000.0D; 
/* 717 */       this.t = (int)(this.time * 12.8D) & 0x7F;
/*     */     }
/*     */ 
/*     */     
/*     */     private static class LeafTile
/*     */     {
/*     */       private static final int ticks = 128;
/*     */       
/*     */       private static final int tmask = 127;
/*     */       private static final int amount = 4;
/*     */       private static final double time = 10.0D;
/*     */       private static final double ticksPerTime = 12.8D;
/* 729 */       private final byte[][] xs = new byte[128][4];
/* 730 */       private final byte[][] ys = new byte[128][4];
/* 731 */       private final int ran = RND.rInt(32);
/*     */ 
/*     */       
/*     */       private LeafTile() {
/* 735 */         for (int a = 0; a < 4; a++) {
/*     */           
/* 737 */           double dvx = -(384.0F + RND.rFloat(384.0D));
/* 738 */           double dvy = (384.0F + RND.rFloat0(96.0D));
/* 739 */           dvx /= 128.0D;
/* 740 */           dvy /= 128.0D;
/* 741 */           double y = RND.rInt(64);
/* 742 */           double x = RND.rInt(32);
/*     */           
/* 744 */           int tStart = RND.rInt(128);
/* 745 */           int tStop = 8 + RND.rInt(24);
/*     */           
/* 747 */           double xsin = RND.rFloat(1.0D);
/*     */ 
/*     */           
/* 750 */           double ysin = RND.rFloat(1.0D);
/* 751 */           double dsin = (RND.rFloat() / 128.0F);
/*     */           
/* 753 */           for (int t = 0; t < 128; t++) {
/*     */             
/* 755 */             this.xs[tStart][a] = (byte)(int)x;
/* 756 */             this.ys[tStart][a] = (byte)(int)y;
/*     */ 
/*     */             
/* 759 */             tStop--;
/* 760 */             if (tStop >= 0) {
/* 761 */               x += dvx * Math.sin(xsin);
/* 762 */               y += dvy * Math.sin(ysin);
/* 763 */               xsin += dsin;
/* 764 */               ysin += dsin;
/*     */             } 
/* 766 */             tStart++;
/* 767 */             tStart &= 0x7F;
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       private void render(int x, int y, int t, int amount) {
/* 774 */         byte[] xs = this.xs[t];
/* 775 */         byte[] ys = this.ys[t];
/*     */         
/* 777 */         for (int i = 0; i < amount; i++) {
/* 778 */           (SETT.TERRAIN()).colors.tree.get(this.ran).bind();
/* 779 */           CORE.renderer().renderParticle(x + xs[i], y + ys[i]);
/*     */         } 
/* 781 */         COLOR.unbind();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class TForestTop
/*     */   {
/* 790 */     private final int max = 32;
/* 791 */     private final double[] speeds = new double[32];
/* 792 */     private final double[] speedsMax = new double[32];
/*     */     
/* 794 */     private final TileTexture.TileTextureScroller[] dis = new TileTexture.TileTextureScroller[32];
/*     */     
/*     */     public TForestTop() {
/* 797 */       for (int i = 0; i < 32; i++) {
/* 798 */         this.speedsMax[i] = 0.5D + RND.rFloat();
/* 799 */         this.speeds[i] = 0.5D + RND.rFloat();
/* 800 */         this.dis[i] = (SPRITES.textures()).dis_low.scroller(72.0D, -66.0D);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void update(double ds) {
/* 808 */       for (int i = 0; i < 32; i++) {
/* 809 */         if (this.speeds[i] > this.speedsMax[i]) {
/* 810 */           this.speeds[i] = this.speeds[i] - this.speedsMax[i] * ds * 0.2D;
/* 811 */           if (this.speeds[i] < this.speedsMax[i])
/* 812 */             this.speedsMax[i] = 0.5D + RND.rFloat(); 
/* 813 */         } else if (this.speeds[i] <= this.speedsMax[i]) {
/* 814 */           this.speeds[i] = this.speeds[i] + this.speedsMax[i] * ds * 0.2D;
/* 815 */           if (this.speeds[i] >= this.speedsMax[i])
/* 816 */             this.speedsMax[i] = 0.5D + RND.rFloat(); 
/*     */         } 
/* 818 */         this.dis[i].update(ds * this.speeds[i] * (SETT.WEATHER()).wind.getD());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(int x, int y, SPRITE_RENDERER r, int tile, RenderData.RenderIterator i, int ran) {
/* 826 */       ran &= 0x1F;
/* 827 */       OPACITY.O50.bind();
/* 828 */       TextureCoords t = (SPRITES.textures()).dots.get(i.tx(), i.ty(), 0.0D, 0.0D);
/* 829 */       TextureCoords d = this.dis[ran].get(i.tx(), i.ty());
/* 830 */       CORE.renderer().renderDisplaced(x, x + 64, y, y + 64, d, t);
/* 831 */       OPACITY.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Swayer
/*     */   {
/* 838 */     private final int am = 64;
/* 839 */     private final byte[] dx = Alloc.bb(64);
/* 840 */     private final byte[] dy = Alloc.bb(64);
/*     */     
/* 842 */     private final double[] dz = new double[64];
/* 843 */     private double[] ran = new double[64];
/*     */     
/*     */     double dd;
/*     */     
/* 847 */     private double lastSecond = 0.0D;
/*     */     
/*     */     Swayer() {
/* 850 */       for (int i = 0; i < 64; i++) {
/* 851 */         this.dx[i] = (byte)RND.rInt(16);
/* 852 */         this.dy[i] = (byte)RND.rInt(16);
/* 853 */         this.ran[i] = RND.rFloat() * Math.PI * 2.0D;
/* 854 */         this.dz[i] = 0.1D + 0.9D * RND.rFloat();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void update() {
/* 861 */       if (TIME.currentSecond() == this.lastSecond) {
/*     */         return;
/*     */       }
/* 864 */       double ds = TIME.currentSecond() - this.lastSecond;
/* 865 */       this.lastSecond = TIME.currentSecond();
/*     */       
/* 867 */       double d = ((SETT.WEATHER()).wind.getD() - 0.4D) / 0.4D;
/* 868 */       if (d < 0.0D) {
/* 869 */         d = 0.0D;
/*     */       }
/* 871 */       this.dd += ds * d * 4.0D;
/*     */       
/* 873 */       for (int i = 0; i < 64; i++) {
/* 874 */         double cos = Math.cos(this.dd + this.ran[i]);
/* 875 */         double a = this.dz[i] * 4.0D * cos;
/* 876 */         this.dx[i] = (byte)(int)a;
/* 877 */         this.dy[i] = (byte)(int)a;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TForest$Sprites.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */