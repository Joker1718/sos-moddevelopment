/*    */ package view.ui;
/*    */ 
/*    */ import view.sett.ui.health.UIHealth;
/*    */ import view.ui.div.UIDiv;
/*    */ import view.ui.economy.UITreasury;
/*    */ import view.ui.family.UIFamilyTree;
/*    */ import view.ui.goods.UIGoods;
/*    */ import view.ui.log.UILog;
/*    */ import view.ui.manage.IManager;
/*    */ import view.ui.profile.UILevel;
/*    */ import view.ui.profile.UIProfile;
/*    */ import view.ui.raider.UIRaiding;
/*    */ import view.ui.tech.UITechTree;
/*    */ import view.ui.tourism.UITourists;
/*    */ import view.ui.wiki.WIKI;
/*    */ 
/*    */ public class UIView
/*    */ {
/*    */   public final UITreasury economy;
/*    */   public final UITourists tourists;
/*    */   public final UIGoods goods;
/*    */   public final UITechTree tech;
/*    */   public final UIRaiding raider;
/*    */   public final UIProfile profile;
/*    */   public final UIFamilyTree family;
/*    */   public final UILevel level;
/*    */   public final UIHealth health;
/* 28 */   public final UILog log = new UILog(null);
/* 29 */   public final WIKI wiki = new WIKI();
/* 30 */   public final UIDiv div = new UIDiv();
/*    */   
/*    */   public UIView() {
/* 33 */     this.economy = new UITreasury();
/* 34 */     this.goods = new UIGoods();
/* 35 */     this.tech = new UITechTree();
/* 36 */     this.level = new UILevel();
/* 37 */     this.family = new UIFamilyTree();
/* 38 */     this.profile = new UIProfile(true);
/* 39 */     this.health = new UIHealth();
/* 40 */     this.tourists = new UITourists();
/* 41 */     this.raider = new UIRaiding();
/* 42 */     this.manager = new IManager(this);
/*    */   }
/*    */   
/*    */   public final IManager manager;
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\UIView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */