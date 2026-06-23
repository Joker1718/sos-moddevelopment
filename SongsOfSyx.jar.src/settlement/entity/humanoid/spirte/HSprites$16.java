/*     */ package settlement.entity.humanoid.spirte;
/*     */ 
/*     */ import init.race.appearence.RAddon;
/*     */ import init.race.appearence.RType;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsAppearance;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends HSprite
/*     */ {
/*     */   null(double $anonymous0, double $anonymous1) {
/* 594 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Humanoid a, AIManager d, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 599 */     Induvidual in2 = a.indu();
/* 600 */     StatsAppearance ap = STATS.APPEARANCE();
/*     */     
/* 602 */     x -= 16;
/* 603 */     y -= 16;
/*     */     
/* 605 */     TILE_SHEET sheet = (a.race().appearance().sheet(in2)).sheet.lay;
/* 606 */     int dir = a.speed.dir().id();
/*     */     
/* 608 */     if (a.physics.getZ() != 0.0D) {
/* 609 */       int t = (int)a.spriteTimer;
/* 610 */       if (t > 8) {
/* 611 */         a.spriteTimer = 0.0F;
/* 612 */         t = 0;
/*     */       } 
/* 614 */       dir += t;
/* 615 */       dir &= 0x7;
/* 616 */       s.setHeight(0).setDistance2Ground(a.physics.getZ());
/* 617 */       sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 618 */     } else if (!a.inWater) {
/* 619 */       s.setHeight(5).setDistance2Ground(0.0D);
/* 620 */       sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 621 */       SETT.PARTICLES().renderDust(x + 64, y + 64, a.speed.magnitude());
/*     */     } 
/*     */     
/* 624 */     for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsBelow) {
/* 625 */       add.renderLaying(r, dir, x, y, in2, false);
/*     */     }
/*     */     
/* 628 */     boolean naked = ((STATS.POP()).NAKED.get(in2) == 1);
/* 629 */     if (!naked) {
/* 630 */       ap.colorLegs(in2).bind();
/*     */     } else {
/* 632 */       ap.colorSkin(in2).bind();
/* 633 */     }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.PANTS + dir, x, y);
/* 634 */     ap.colorSkin(in2).bind();
/* 635 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.ARMS + dir, x, y);
/* 636 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.HEAD + dir, x, y);
/*     */     
/* 638 */     if (!naked) {
/* 639 */       ap.colorClothes(in2).bind();
/*     */     } else {
/* 641 */       ap.colorSkin(in2).bind();
/* 642 */     }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.TORSO + dir, x, y);
/*     */     
/* 644 */     for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 645 */       add.renderLaying(r, dir, x, y, in2, false);
/*     */     }
/* 647 */     COLOR.unbind();
/*     */     
/* 649 */     if (baby(a.indu())) {
/* 650 */       int cx = x + sheet.size() / 2;
/* 651 */       int cy = y + sheet.size() / 2;
/* 652 */       DIR dirr = (DIR)DIR.ALL.get(dir);
/* 653 */       int dx = cx;
/* 654 */       int dy = cy;
/* 655 */       in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */     } 
/*     */     
/* 658 */     OPACITY.O75.bind();
/*     */     
/* 660 */     if (a.inWater) {
/* 661 */       HSpriteConst.CLAY.water(in2, dir, x, y);
/*     */     } else {
/* 663 */       HSpriteConst.CLAY.blood(in2, dir, x, y);
/* 664 */       HSpriteConst.CLAY.filth(in2, dir, x, y);
/*     */     } 
/* 666 */     OPACITY.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void tick(Humanoid a, double ds) {
/* 671 */     if (a.physics.getZ() != 0.0D) {
/* 672 */       a.spriteTimer = (float)(a.spriteTimer + a.speed.magnitudeRelative() * ds * 15.0D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderSimple(Humanoid a, AIManager ai, Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 679 */     Induvidual in2 = a.indu();
/* 680 */     StatsAppearance ap = STATS.APPEARANCE();
/*     */     
/* 682 */     x -= 16;
/* 683 */     y -= 16;
/*     */     
/* 685 */     TILE_SHEET sheet = (a.race().appearance().sheet(in2)).sheet.lay;
/* 686 */     int dir = a.speed.dir().id();
/*     */     
/* 688 */     if (a.physics.getZ() != 0.0D) {
/* 689 */       int t = (int)a.spriteTimer;
/* 690 */       if (t > 8) {
/* 691 */         a.spriteTimer = 0.0F;
/* 692 */         t = 0;
/*     */       } 
/* 694 */       dir += t;
/* 695 */       dir &= 0x7;
/* 696 */       s.setHeight(0).setDistance2Ground(a.physics.getZ());
/* 697 */       sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 698 */     } else if (!a.inWater) {
/* 699 */       s.setHeight(5).setDistance2Ground(0.0D);
/* 700 */       sheet.render((SPRITE_RENDERER)s, HSpriteConst.CLAY.SHADOW + dir, x, y);
/* 701 */       SETT.PARTICLES().renderDust(x + 64, y + 64, a.speed.magnitude());
/*     */     } 
/*     */     
/* 704 */     boolean naked = ((STATS.POP()).NAKED.get(in2) == 1);
/* 705 */     if (!naked) {
/* 706 */       ap.colorLegs(in2).bind();
/*     */     } else {
/* 708 */       ap.colorSkin(in2).bind();
/* 709 */     }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.PANTS + dir, x, y);
/* 710 */     ap.colorSkin(in2).bind();
/* 711 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.ARMS + dir, x, y);
/* 712 */     sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.HEAD + dir, x, y);
/* 713 */     if (!naked) {
/* 714 */       ap.colorClothes(in2).bind();
/*     */     } else {
/* 716 */       ap.colorSkin(in2).bind();
/* 717 */     }  sheet.render((SPRITE_RENDERER)r, HSpriteConst.CLAY.TORSO + dir, x, y);
/*     */     
/* 719 */     for (RAddon add : ((RType)(in2.race().appearance()).types.getC(ap.gender.get(in2))).addonsAbove) {
/* 720 */       add.renderLaying(r, dir, x, y, in2, false);
/*     */     }
/* 722 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 729 */     COLOR.unbind();
/*     */     
/* 731 */     if (baby(a.indu())) {
/* 732 */       int cx = x + sheet.size() / 2;
/* 733 */       int cy = y + sheet.size() / 2;
/* 734 */       DIR dirr = (DIR)DIR.ALL.get(dir);
/* 735 */       int dx = cx;
/* 736 */       int dy = cy;
/* 737 */       in2.race().appearance().renderBaby((SPRITE_RENDERER)r, dx, dy, dirr.id(), STATS.RAN().get(in2, 4));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean baby(Induvidual in) {
/* 743 */     return (in.hType().child() != null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\spirte\HSprites$16.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */