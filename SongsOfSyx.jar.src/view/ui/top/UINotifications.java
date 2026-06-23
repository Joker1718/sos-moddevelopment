/*     */ package view.ui.top;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.ColorShifting;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ 
/*     */ 
/*     */ public final class UINotifications
/*     */   extends GuiSection
/*     */ {
/*  65 */   private static final LinkedList<UINotification> butts = new LinkedList();
/*     */   
/*     */   private static boolean created = false;
/*     */   private HOVERABLE invasion;
/*     */   private Siege siege;
/*     */   private static final int BW = 46;
/*  71 */   private static final int max = 6 + (C.WIDTH() - 1280) / 92;
/*     */   
/*  73 */   private static CharSequence ¤¤constructed = "Regions that can be upgraded";
/*  74 */   private static CharSequence ¤¤regProblem = "Regions in trouble";
/*  75 */   private static CharSequence ¤¤siege = "Sieges";
/*  76 */   private static CharSequence ¤¤siegeD = "Amount of regions currently under siege";
/*  77 */   private static CharSequence ¤¤wrong = "Wrongful deaths";
/*  78 */   private static CharSequence ¤¤wrongD = "Some subjects have died in ways that could have been prevented.";
/*  79 */   private static CharSequence ¤¤room = "New Rooms";
/*  80 */   private static CharSequence ¤¤roomD = "New rooms that have been constructed.";
/*  81 */   private static CharSequence ¤¤roomB = "Broken Rooms";
/*  82 */   private static CharSequence ¤¤roomBD = "Rooms that have been broken and needs repair.";
/*     */   
/*  84 */   private static CharSequence ¤¤closed = "Your throne can not be reached from the outside world. As a consequence, no immigration or trade can occur. Clear a path from the throne to a country road as soon as possible.";
/*     */   
/*  86 */   private static CharSequence ¤¤supply = "Supply Issues";
/*  87 */   private static CharSequence ¤¤supplyD = "Some of our armies are low on crucial supplies. This can be due to supplies being cut off from your capitol, poor production, or supply depot problems. If not supplied armies will desert.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*  99 */     D.ts(UINotifications.class);
/*     */   }
/*     */ 
/*     */   
/*     */   UINotifications() {
/* 104 */     if (!created)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 607 */       created = true;
/*     */     }
/*     */     
/* 610 */     this.siege = new Siege();
/*     */     
/* 612 */     this.invasion = (HOVERABLE)new HOVERABLE.HoverableAbs(32, 22)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */         {
/* 616 */           GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*     */           
/* 618 */           (GCOLOR.T()).IBAD.bind();
/*     */           
/* 620 */           if (SETT.INVADOR().invadingPending()) {
/* 621 */             (UI.icons()).s.degrade.renderC(r, (RECTANGLE)this.body);
/*     */           } else {
/* 623 */             (UI.icons()).s.cancel.renderC(r, (RECTANGLE)this.body);
/* 624 */           }  COLOR.unbind();
/* 625 */           GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 632 */           if (SETT.INVADOR().invadingPending()) {
/* 633 */             SETT.INVADOR().hover(text);
/*     */           } else {
/* 635 */             text.text(UINotifications.¤¤closed);
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 641 */     body().setDim((max * ((UINotification)butts.get(0)).body.width()), ((UINotification)butts.get(0)).body().height());
/*     */     
/* 643 */     D.spop();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Siege
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/* 650 */     int aii = 0;
/* 651 */     int am = 0;
/* 652 */     int amLast = 0;
/*     */     
/*     */     public Siege() {
/* 655 */       super(32, 22);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 660 */       GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/*     */       
/* 662 */       for (WArmy a : FACTIONS.player().armies().all()) {
/* 663 */         if (a.besieging() != null) {
/* 664 */           double p = RD.MILITARY().defensePower(a.besieging()) * (1.0D - RD.MILITARY().besigeMul(a.besieging()));
/* 665 */           p /= AD.power().get(a);
/*     */           
/* 667 */           if (p > 1.0D) {
/* 668 */             (GCOLOR.T()).IBAD.bind();
/* 669 */           } else if (p < 0.5D) {
/* 670 */             (GCOLOR.T()).IGREAT.bind();
/*     */           } else {
/* 672 */             (GCOLOR.T()).IGOOD.bind();
/* 673 */           }  (UI.icons()).s.shield.renderC(r, (RECTANGLE)this.body);
/*     */         } 
/*     */       } 
/* 676 */       COLOR.unbind();
/* 677 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 684 */       for (WArmy a : FACTIONS.player().armies().all()) {
/* 685 */         if (a.besieging() != null) {
/* 686 */           VIEW.world().activate();
/* 687 */           (VIEW.world()).window.centererTile.set(a.ctx(), a.cty());
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     public int am() {
/* 694 */       if (this.aii >= FACTIONS.player().armies().all().size()) {
/* 695 */         this.amLast = this.am;
/* 696 */         this.am = 0;
/* 697 */         this.aii = 0;
/* 698 */         return this.amLast;
/*     */       } 
/* 700 */       WArmy a = (WArmy)FACTIONS.player().armies().all().get(this.aii);
/* 701 */       if (a != null && a.besieging() != null) {
/* 702 */         this.am++;
/*     */       }
/* 704 */       this.aii++;
/*     */       
/* 706 */       return this.amLast;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 711 */       GBox b = (GBox)text;
/* 712 */       b.title(Dic.¤¤Besiege);
/*     */       
/* 714 */       for (WArmy a : FACTIONS.player().armies().all()) {
/* 715 */         if (a.besieging() != null) {
/* 716 */           b.textLL(Dic.¤¤Army);
/* 717 */           b.tab(6);
/* 718 */           b.text((CharSequence)a.name);
/* 719 */           b.NL();
/* 720 */           b.textLL(Dic.¤¤Region);
/* 721 */           b.tab(6);
/* 722 */           b.text((CharSequence)(a.besieging()).info.name());
/* 723 */           b.NL();
/* 724 */           b.textLL(DicTime.¤¤Days);
/* 725 */           b.tab(6);
/* 726 */           b.text((CharSequence)GFORMAT.f(b.text(), WORLD.BATTLES().besigedTime(a.besieging()) / TIME.secondsPerDay()));
/* 727 */           b.NL();
/* 728 */           b.textLL(Dic.¤¤Defences);
/* 729 */           b.tab(6);
/*     */           
/* 731 */           double p = RD.MILITARY().defensePower(a.besieging()) * (1.0D - RD.MILITARY().besigeMul(a.besieging()));
/* 732 */           p /= AD.power().get(a);
/* 733 */           p = 1.0D - p;
/* 734 */           b.text((CharSequence)GFORMAT.percInv(b.text(), p));
/* 735 */           b.NL();
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void add(RENDEROBJ b, int i) {
/* 746 */     b.body().moveX1Y1((b.body().width() * i / 2), (b.body().height() * i % 2));
/* 747 */     addRightC(0, b);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 752 */     int x1 = body().x1();
/* 753 */     int y1 = body().y1();
/* 754 */     clear();
/* 755 */     int am = 0;
/* 756 */     if (SETT.ENTRY().isClosed())
/* 757 */       addRight(0, (RENDEROBJ)this.invasion); 
/* 758 */     if (this.siege.am() > 0)
/* 759 */       addRight(0, (RENDEROBJ)this.siege); 
/* 760 */     for (UINotification b : butts) {
/* 761 */       if (b.get() > 0) {
/* 762 */         addRight(0, (RENDEROBJ)b);
/* 763 */         am++;
/* 764 */         if (am > max)
/*     */           return; 
/*     */       } 
/*     */     } 
/* 768 */     body().moveX1Y1(x1, y1);
/* 769 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   public static abstract class UINotification
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/* 775 */     private final GText text = new GText((UI.FONT()).S, 10);
/* 776 */     private static final COLOR flashBg = (COLOR)(new ColorShifting(GCOLOR.UI().bg(), (COLOR)GCOLOR.UI().bg().shade(4.0D))).setSpeed(1.5D);
/*     */     
/*     */     private final SPRITE icon;
/*     */     private final COLOR color;
/*     */     private boolean showNumber;
/* 781 */     int lastValue = -1;
/* 782 */     double flashFor = 0.0D;
/*     */     
/*     */     public UINotification(SPRITE icon, COLOR color, boolean showNumber) {
/* 785 */       this.icon = icon;
/* 786 */       this.color = color;
/* 787 */       this.body.setDim((showNumber ? 46 : 22), 22.0D);
/* 788 */       this.showNumber = showNumber;
/* 789 */       UINotifications.butts.add(this);
/*     */     }
/*     */     
/*     */     public UINotification(SPRITE icon, COLOR color, CharSequence hover) {
/* 793 */       this(icon, color, true);
/* 794 */       hoverInfoSet(hover);
/* 795 */       this.body.setDim(46.0D, 22.0D);
/*     */     }
/*     */     
/*     */     public UINotification(SPRITE icon, COLOR color, CharSequence name, CharSequence desc) {
/* 799 */       this(icon, color, true);
/* 800 */       hoverTitleSet(name);
/* 801 */       hoverInfoSet(desc);
/* 802 */       this.body.setDim(46.0D, 22.0D);
/*     */     }
/*     */     
/*     */     public UINotification(SPRITE icon, COLOR color, INFO info) {
/* 806 */       this(icon, color, true);
/* 807 */       hoverTitleSet(info.name);
/* 808 */       hoverInfoSet(info.desc);
/* 809 */       this.body.setDim(46.0D, 22.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 815 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body);
/* 816 */       int am = get();
/* 817 */       if (this.lastValue == -1 || this.lastValue != am) {
/* 818 */         this.lastValue = am;
/* 819 */         this.flashFor = 20.0D;
/*     */       } else {
/* 821 */         this.flashFor -= ds;
/*     */       } 
/*     */       
/* 824 */       if (this.flashFor > 0.0D) {
/* 825 */         flashBg.render(r, (RECTANGLE)this.body, -1);
/*     */       } else {
/* 827 */         GCOLOR.UI().bg(true, isHovered, false).render(r, (RECTANGLE)this.body, -1);
/*     */       } 
/*     */       
/* 830 */       ColorImp.TMP.set(this.color);
/*     */       
/* 832 */       ColorImp.TMP.set(this.color).bind();
/* 833 */       this.icon.renderCY(r, body().x1() + 2, body().cY());
/* 834 */       COLOR.unbind();
/*     */       
/* 836 */       this.text.clear();
/* 837 */       if (this.showNumber) {
/* 838 */         GFORMAT.i(this.text, CLAMP.i(am, 0, 99));
/* 839 */         this.text.adjustWidth();
/* 840 */         this.text.renderCY(r, body().x1() + 20, body().cY() + 2);
/* 841 */         this.text.color(COLOR.WHITE100);
/*     */       } 
/*     */ 
/*     */       
/* 845 */       OPACITY.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 850 */       if (super.hover(mCoo)) {
/* 851 */         this.flashFor = 0.0D;
/* 852 */         if (MButt.RIGHT.consumeClick()) {
/* 853 */           supress();
/*     */         }
/* 855 */         return true;
/*     */       } 
/* 857 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void supress() {}
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 866 */       super.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract int get();
/*     */   }
/*     */   
/*     */   private static class NotiStat
/*     */     extends UINotification
/*     */   {
/* 876 */     int k = 0;
/*     */     private final STAT s;
/*     */     
/*     */     public NotiStat(SPRITE icon, COLOR color, STAT s) {
/* 880 */       super(icon, color, (INFO)s.info());
/* 881 */       this.s = s;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int get() {
/* 887 */       int ch = this.s.type().get(HTYPE_RACE.get(HTYPES.CHILD()));
/* 888 */       ch += this.s.type().get(HTYPE_RACE.get(HTYPES.CHILD_SLAVE()));
/* 889 */       return this.s.data(null).get(null) + ch;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 894 */       this.k = showNextH(this.k, this.s);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 899 */       super.hoverInfoGet(text);
/*     */       
/* 901 */       GBox b = (GBox)text;
/* 902 */       b.NL();
/* 903 */       b.tab(6);
/* 904 */       b.textLL((HCLASSES.CITIZEN()).names);
/* 905 */       b.tab(9);
/* 906 */       b.textLL((HCLASSES.SLAVE()).names);
/* 907 */       b.tab(12);
/* 908 */       b.textLL((HCLASSES.NOBLE()).names);
/* 909 */       b.NL();
/* 910 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 911 */         Race r = (FACTIONS.player()).races.get(ri);
/* 912 */         b.add((SPRITE)(r.appearance()).icon);
/* 913 */         b.textL(r.info.names);
/* 914 */         b.tab(6);
/* 915 */         b.add((SPRITE)GFORMAT.i(b.text(), this.s.data(HCLASSES.CITIZEN()).get(r)));
/* 916 */         b.tab(9);
/* 917 */         b.add((SPRITE)GFORMAT.i(b.text(), this.s.data(HCLASSES.SLAVE()).get(r)));
/* 918 */         b.tab(12);
/* 919 */         b.add((SPRITE)GFORMAT.i(b.text(), this.s.data(HCLASSES.NOBLE()).get(r)));
/* 920 */         b.NL();
/*     */       } 
/*     */       
/* 923 */       b.NL(4);
/*     */       
/* 925 */       int ch = this.s.type().get(HTYPE_RACE.get(HTYPES.CHILD()));
/* 926 */       ch += this.s.type().get(HTYPE_RACE.get(HTYPES.CHILD_SLAVE()));
/*     */       
/* 928 */       b.textL((HTYPES.CHILD()).names);
/* 929 */       b.tab(6);
/* 930 */       b.add((SPRITE)GFORMAT.i(b.text(), ch));
/*     */     }
/*     */ 
/*     */     
/*     */     private int showNextH(int k, STAT s) {
/* 935 */       ENTITY[] es = SETT.ENTITIES().getAllEnts();
/* 936 */       for (int q = 0; q < es.length; q++) {
/* 937 */         if (k >= es.length)
/* 938 */           k = 0; 
/* 939 */         ENTITY e = es[k];
/* 940 */         k++;
/* 941 */         if (e instanceof Humanoid && s.indu().isMax(((Humanoid)e).indu())) {
/* 942 */           Humanoid h = (Humanoid)e;
/* 943 */           if ((h.indu().hType().parent()).CLASS.player && s.indu().isMax(h.indu())) {
/* 944 */             VIEW.s().activate();
/* 945 */             (VIEW.s().getWindow()).centererTile.set(e.tc());
/* 946 */             (VIEW.s()).ui.subjects.show((Humanoid)e);
/*     */           } 
/* 948 */           return k;
/*     */         } 
/*     */       } 
/*     */       
/* 952 */       return k;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UINotifications.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */